package application.model;

public class Funcionario {

	private String login;
	private String senha;
	private String area;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "funcionario [login=" + login + ", senha=" + senha + ", area=" + area + "]";
	}
}
