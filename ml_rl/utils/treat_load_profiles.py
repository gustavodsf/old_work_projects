from dateutil import parser
from statistics import mean
import pandas as pd
import matplotlib.pyplot as plt


def treat_load_profile(file):
    OUTPUT_FILE_NAME = "LOAD_PROFILE_07022020_FRI.csv"
    real = []
    predicted = []
    time = []
    with open(file, 'r') as f:
        line = f.readline()
        while True:
            line = f.readline()
            if not line:
                break
            line = [l.strip() for l in line.strip().split("|")]
            if len(line) > 3:

                try:
                    real.append(float(line[-1]))
                    predicted.append(float(line[-2]))
                    time.append(parser.parse(
                        line[1]))

                except Exception:
                    continue

    data = [[d, v1, v2] for d, v1, v2 in zip(time, real, predicted)]
    data = pd.DataFrame(
        data, columns=['date', 'real value', 'predicted value'])
    data.set_index('date', inplace=True)
    data.dropna(inplace=True)
    data = data.resample('T').mean()[0:1440]
    # data = data.resample('T').pad().bfill()[0:1440]

    print(data)

    real_data = [x / mean(list(data['real value']))
                 for x in list(data['real value'])]
    pred_data = [x / mean(list(data['predicted value']))
                 for x in list(data['predicted value'])]
    plt.plot([x for x in range(len(real_data))],
             real_data, color='r')
    plt.plot([x for x in range(len(pred_data))],
             pred_data, color='b')
    plt.show()

    with open(r"C:\Users\mauricio.barg\source\repos\drl-vcontrol\utils\load_profiles\\" + "REAL_" + OUTPUT_FILE_NAME, 'w') as f:
        for i, v in enumerate(real_data):
            f.write(str(i + 1) + ";" + str(v) + "\n")

    with open(r"C:\Users\mauricio.barg\source\repos\drl-vcontrol\utils\load_profiles\\" + "PRED_" + OUTPUT_FILE_NAME, 'w') as f:
        for i, v in enumerate(pred_data):
            f.write(str(i + 1) + ";" + str(v) + "\n")


treat_load_profile(
    r"C:\Users\mauricio.barg\source\repos\drl-vcontrol\utils\load_profiles\bhpas_h_2019_02_07.csv")
