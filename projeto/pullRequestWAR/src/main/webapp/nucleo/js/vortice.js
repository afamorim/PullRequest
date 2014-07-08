/*
 * Menu
 */

function MM_findObj(n, d) { //v4.0
	var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	if(!x && document.getElementById) x=document.getElementById(n); return x;
}
function MM_dmenu(objname) {
	var obj = MM_findObj(objname);
	if(obj && obj.style) obj.style.display = (obj.style.display=="none") ? "" : "none";
}
function MM_dmenuh() {
	var a=MM_dmenuh.arguments;
	for (i=0; i<a.length; i++) {var obj = MM_findObj(a[i]); if(obj && obj.style) obj.style.display = "none"; }
}

/*
Ex:onkeyup='formatarCampoNumero(this)'
*/
function formatarCampoNumero(campo) {
	soNumero(campo);
	valor = campo.value;
	while(valor.indexOf(" ") >= 0) valor = valor.replace(" ", "");
	while(valor.indexOf(".") >= 0) valor = valor.replace(".", "");
	while(valor.indexOf(",") >= 0) valor = valor.replace(",", "");
	if (valor.length < 2) {
		campo.value = valor;
		return;
	}
	saida = valor.substring(0,1);
	valor = valor.substring(1, valor.length);
	while (valor.length - 2 > 0) {
		if ((valor.length - 2) % 3 == 0) {
			saida += ".";
		}
		saida += valor.substring(0,1);
	    valor = valor.substring(1, valor.length);
	}
	saida += "," + valor;
	campo.value = saida;
}

/**
**/
function soNumero(campo) {
	var caracteresIvalidos = "1234567890";
	for (i = 0; i < campo.value.length; i++) {
		if (caracteresIvalidos.indexOf(campo.value.charAt(i)) == -1) {
			temp1 = campo.value.substr(0, i);
			temp2 = campo.value.substr(i + 1, campo.value.length);
			campo.value = temp1 + temp2;
			i = 0;
		}
	}
}

function Mascara(objeto, evt, mask) 
{
	var LetrasU = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var LetrasL = 'abcdefghijklmnopqrstuvwxyz';
	var Letras  = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
	var Numeros = '0123456789';
	var NumerosX = '0123456789Xx';
	var Fixos  = '().-:/ ';
	var Charset = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_/`abcdefghijklmnopqrstuvwxyz{|}~";

	evt = (evt) ? evt : (window.event) ? window.event : "";
	var value = objeto.value;
	if (evt) {
		var ntecla = (evt.which) ? evt.which : evt.keyCode;
		tecla = Charset.substr(ntecla - 32, 1);
		if (ntecla < 32) return true;
	
		var tamanho = value.length;
		if (tamanho > mask.length) {
			valor = objeto.value;
			valor = valor.substring(0, valor.length-1);
			objeto.value = valor;
			return false;
		}
	
		var pos = mask.substr(tamanho,1);
		while (Fixos.indexOf(pos) != -1) {
			value += pos;
			tamanho = value.length;
			if (tamanho >= mask.length) return false;
			pos = mask.substr(tamanho,1);
		}

		switch (pos) {
			case '#' : if (Numeros.indexOf(tecla) == -1) return false; break;
			case 'A' : if (LetrasU.indexOf(tecla) == -1) return false; break;
			case 'a' : if (LetrasL.indexOf(tecla) == -1) return false; break;
			case 'Z' : if (Letras.indexOf(tecla) == -1) return false; break;
			case 'X' : if (NumerosX.indexOf(tecla) == -1) return false; break;
			case '*' : objeto.value = value; return true; break;
			default : return false; break;
		}
	}
	objeto.value = value;
	return true;
}

function MaskHora(objeto, evt) {
	return Mascara(objeto, evt, '##:##');
}

function MaskCEP(objeto, evt) {
	return Mascara(objeto, evt, '##.###-###');
}

function MaskTelefone(objeto, evt) {
	return Mascara(objeto, evt, '(##) ####-####');
}

function MaskCPF(objeto, evt) {
	return Mascara(objeto, evt, '###.###.###-##');
}

function MaskPlacaCarro(objeto, evt) {
	return Mascara(objeto, evt, 'AAA-####');
}

function maskDate(objeto, evt) {
	return Mascara(objeto, evt, '##/##/####');
}

function justNumber(objeto, evt) {
	return Mascara(objeto, evt, '#######################');
}

function justNumberX(objeto, evt) {
	return Mascara(objeto, evt, 'X');
}

function checkDate(input){
	var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
	var returnval=false;
	
	if (input.value=='') {
		return;
	}
	
	if (!validformat.test(input.value)) {
		alert("Data inválida.");
		input.value = '';
		input.focus();
	}
	else{ //Detailed check for valid date ranges
		if (input.value == '18/10/2009') return true;
	var dayfield=input.value.split("/")[0];
	var monthfield=input.value.split("/")[1];
	var yearfield=input.value.split("/")[2];
	var dayobj = new Date(yearfield, monthfield-1, dayfield);
	if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getFullYear()!=yearfield)) {
		if ((dayobj.getDate()!=dayfield) || (dayobj.getDate()+1!=dayfield)){
			alert("Data inv�lida. 2");
			input.value = '';
			input.focus();
		}
	}
	else
	returnval=true;
	}
	if (returnval==false) input.select();
	return returnval;
}

//calcular a idade de uma pessoa 
//recebe a data como um string em formato portugues 
//devolve um inteiro com a idade. Devolve false em caso de que a data seja incorreta ou maior que o dia atual 
function calcular_idade(data){ 

 	//calculo a data de hoje 
	hoje=new Date();
 	//alert(hoje) 

 	//calculo a data que recebo 
 	//descomponho a data em um array
 	var array_data = data.split("/");
 	//se o array nao tem tres partes, a data eh incorreta 
 	if (array_data.length!=3) 
    	 return false;

 	//comprovo que o ano, mes, dia s�o corretos 
 	var ano;
 	ano = parseInt(array_data[2]); 
 	if (isNaN(ano)) 
    	 return false;

 	var mes;
 	mes = parseInt(array_data[1]); 
 	if (isNaN(mes)) 
    	 return false;

 	var dia;
 	dia = parseInt(array_data[0]);	
 	if (isNaN(dia)) 
    	 return false;


 	//se o ano da data que recebo so tem 2 cifras temos que muda-lo a 4 
 	if (ano<=99) 
    	 ano +=1900;

 	//subtraio os anos das duas datas
 	idade=hoje.getFullYear()- ano - 1; //-1 porque ainda nao fez anos durante este ano

 	//se subtraio os meses e for menor que 0 entao nao cumpriu anos. Se for maior sim ja cumpriu 
 	if (hoje.getMonth() + 1 - mes < 0) //+ 1 porque os meses comecam em 0 
    	 return idade;
 	if (hoje.getMonth() + 1 - mes > 0) 
    	 return idade+1 ;
 	
 	//entao eh porque sao iguais. Vejo os dias 
 	//se subtraio os dias e der menor que 0 entao nao cumpriu anos. Se der maior ou igual sim que j� cumpriu 
 	if (hoje.getUTCDate() - dia >= 0) 
    	 return idade + 1; 

 	return idade;
} 