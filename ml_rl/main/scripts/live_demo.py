import matplotlib.pyplot as plt
import matplotlib.animation as animation
from matplotlib import style
from dss_engine import OpenDssEngine
from neural_network import Network
from copy import deepcopy
import numpy as np

import time

weekdays_map = {'MON': 1, 'TUE': 2, 'WED': 3,
                'THU': 4, 'FRI': 5, 'SAT': 6, 'SUN': 7}

system_normal = OpenDssEngine()
system_normal.start()

possible_actions = system_normal.get_possible_actions() + [None]
possible_actions_map = dict({(i, action)
                             for i, action in enumerate(possible_actions)})
smart_agent = Network(
    len(system_normal.get_state().state_space_repr(1, 1, weekdays_map[system_normal.get_weekday()])), len(possible_actions), system_normal.get_file_name())

start_state = deepcopy(system_normal.get_state())
after_action = deepcopy(system_normal.get_state())
fig, ax1 = plt.subplots()
current_time_step = 1
xs = []
real_ys = []
predicted_ys = []
controlled_ys = []


def animate(i):
    global current_time_step, xs, real_ys, predicted_ys, controlled_ys, start_state, after_action
    if current_time_step < system_normal.get_episode_length():
        xs.append(current_time_step)
        system_normal.set_state(start_state)
        system_normal.update_loads(current_time_step)
        real_ys.append(system_normal.evaluate_voltages())
        system_normal.set_state(after_action)
        system_normal.update_loads(current_time_step)
        controlled_system_state = np.expand_dims(np.array(system_normal.get_state().state_space_repr(
            current_time_step, 0, weekdays_map[system_normal.get_weekday()]), dtype=np.float32), 0)
        a = possible_actions_map[int(np.squeeze(np.argmax(
            smart_agent.model(controlled_system_state), -1)))]
        system_normal.take_action(a)
        after_action = deepcopy(system_normal.get_state())
        controlled_ys.append(system_normal.evaluate_voltages())

        current_time_step += 1
    else:
        pass

    ax1.clear()
    p1, = ax1.plot(xs, real_ys, color='red', label='Tensão Normal')
    p2, = ax1.plot(xs, controlled_ys, color='blue', label='Tensão Controlada')
    ax1.axhspan(ymax=1.005, ymin=0.995, color='yellow', alpha=0.15)
    ax1.grid(linestyle='dashed')
    lines = [p1, p2]
    ax1.legend(lines, [l.get_label() for l in lines])
    ax1.set_title('Tensão Média no Sistema')
    ax1.set_ylabel('Tensão (p.u.)')
    ax1.set_xlabel('Minutos')


ani = animation.FuncAnimation(fig, animate, interval=10)


# ani.save('animated.html', writer='imagemagick', fps=30)
plt.show()
