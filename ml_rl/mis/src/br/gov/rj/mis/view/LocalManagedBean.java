package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.LocalEntityBeanInterface;
import br.gov.rj.mis.model.Locais;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name = "localManagedBean")
public class LocalManagedBean {

	private Locais local;
	private Locais localSelecionado;
	private Collection<Locais> locais;
	private List<Locais> localFiltrado;

	@EJB(name = "localEntityBean")
	LocalEntityBeanInterface localEntityBean;

	@PostConstruct
	public void populaCampos() {
		local = new Locais();
		locais = localEntityBean.retrieveAll();
	}

	public void salvarLocal() {

		Locais localConsultado = localEntityBean.consultaLocalByNome(local.getNome());
		// ressuscita local que fora excluido caso o local inserido seja igual
		if (localConsultado != null) {

			localConsultado.setEstado(EstadoRegistro.HABILITADO.toString());
			localEntityBean.editarLocal(localConsultado);

		} else {
			local.setEstado(EstadoRegistro.HABILITADO.toString());
			localEntityBean.salvarLocal(local);
		}
		limparLocal();
		locais.clear();
		locais = localEntityBean.retrieveAll();

		Mensagem.sucesso("localCadastrado");

	}

	public void excluiElementoLocal() {
		locais.remove(localSelecionado);
		localEntityBean.excluirLocal(localSelecionado);
		Mensagem.sucesso("localExcluido");
	}

	public void onEdit(RowEditEvent event) {

		localSelecionado = (Locais) event.getObject();

		Locais localConsultado = localEntityBean
				.consultaLocalByNome(localSelecionado.getNome());

		// edita local atual para outro que fora excluido
		if (localConsultado != null) {

			// salva o id do local a ser editado para futura exclusão
			long idSave = localSelecionado.getId();

			// iguala os id do local a ser aditado, ao local que fora excluido.
			localSelecionado.setId(localConsultado.getId());

			// exclui o local editado
			localConsultado.setId(idSave);
			localEntityBean.excluirLocal(localConsultado);
		}

		localEntityBean.editarLocal(localSelecionado);

		localSelecionado.clear();
		locais.clear();
		locais = localEntityBean.retrieveAll();

		Mensagem.sucesso("localEditado");

	}

	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}

	public void limparLocal() {
		local.clear();
	}

	/* Getter and Setter */
	public Locais getLocal() {
		return local;
	}

	public void setLocal(Locais local) {
		this.local = local;
	}

	public Collection<Locais> getLocais() {
		return locais;
	}

	public void setLocais(Collection<Locais> locais) {
		this.locais = locais;
	}

	public Locais getLocalSelecionado() {
		return localSelecionado;
	}

	public void setLocalSelecionado(Locais localSelecionado) {
		this.localSelecionado = localSelecionado;
	}

	public List<Locais> getLocalFiltrado() {
		return localFiltrado;
	}

	public void setLocalFiltrado(List<Locais> localFiltrado) {
		this.localFiltrado = localFiltrado;
	}

}
