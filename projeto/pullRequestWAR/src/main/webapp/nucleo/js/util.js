PrimeFaces.locales['pt_BR'] = {  
                closeText: 'Fechar',  
                prevText: 'Anterior',  
                nextText: 'Próximo',  
                currentText: 'Começo',  
                monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],  
                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],  
                dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],  
                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],  
                dayNamesMin: ['D','S','T','Q','Q','S','S'],  
                weekHeader: 'Semana',  
                firstDay: 1,  
                isRTL: false,  
                showMonthAfterYear: false,  
                yearSuffix: '',  
                timeOnlyTitle: 'Horas',  
                timeText: 'Tempo',  
                hourText: 'Hora',  
                minuteText: 'Minuto',  
                secondText: 'Segundo',  
                currentText: 'Data Atual',  
                ampm: false,  
                month: 'M��s',  
                week: 'Semana',  
                day: 'Dia',  
                allDayText : 'Todo Dia'  
            };  

var carregouDataHora = false;

function startTime(){
	
	if(!carregouDataHora){
		var today=new Date();
		
		var day=checkTime(today.getDate());
		var month=checkTime(today.getMonth()+1);
		var year=checkTime(today.getFullYear());
		
		var h=checkTime(today.getHours());
		var m=checkTime(today.getMinutes());
		var s=checkTime(today.getSeconds());
		
		document.getElementById('horaCorrente').innerHTML += "     "+day+"/"+month+"/"+year+" "+h+":"+m+":"+s;
		t=setTimeout(function(){startTime()},500);
		carregouDataHora = true;
	}
}

function checkTime(i){
	if (i<10){
	  i="0" + i;
	  }
	return i;
}

function onBlurCopyValueTo(campoOrigem,nomeCampoDestino){
	$("#formTemplate\\:"+nomeCampoDestino).val(campoOrigem.value);
}

function onSelectCopyValueTo(){
	alert('veio1');
}