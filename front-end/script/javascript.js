function verificar()
{
	var nome = document.getElementById("usr").value;
	//verificação do nome
	if(isNaN(nome) == false)
	{
			alert("digite um nome valido"); 
			return false;
	}
	
	//verificação da senha
	
	var senha = document.getElementById("pwd").value;


	if(senha.length < 8)
	{
		alert("A senha deve conter no minímo 8 digitos!");
		
		return false;
	}

	var senhaConfirm = document.getElementById("conpwd").value;
	if(senha != senhaConfirm)
	{
		alert("As senhas não correspondem");
		
		return false;
	}

	var cpf = document.getElementById("cpf").value;
	//verificação do cpf
	if(isNaN(cpf) == true)
	{
			alert("digite um CPF valido"); 
			return false;
	}
	//verificação da idade
	var idade = document.getElementById("idade").value;
	
	if(idade<18 || idade>99)
	{
		alert("Digite uma idade valida");
		return false;
	}	
	
	
}

