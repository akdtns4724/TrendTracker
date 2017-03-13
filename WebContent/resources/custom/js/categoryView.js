var Base_url = "https://ksm-test-dismal-coleopteran.devpack.co.kr/";

function makeChart(keyword) {
	var url = Base_url + "interest/ + keyword";
	var json;
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data){
			json = JSON.parse(data);
	    }
	}).done(function(){
		drawGraph(json, keyword);
	});
}

function drawGraph(data, keyword){
	
    var graphdata = new google.visualization.DataTable();
    
    graphdata.addColumn('date', 'Date');
    graphdata.addColumn('number', keyword);

    for(var i = 0; i < data.default.timelineData.length; i++){
    	graphdata.addRow([new Date(data.default.timelineData[i].formattedTime), data.default.timelineData[i].value[0]]);
    }

    var options = {
      hAxis: {
        title: 'Time'
      },
      vAxis: {
        title: '관심도'
      },
      series: {
        1: {curveType: 'function'}
      },
      annotations: {
    	    textStyle: {
    	      fontName: 'Open Sans',
    	      fontSize: 18,
    	      bold: true,
    	      italic: true,
    	      color: '#871b47',
    	      auraColor: '#d799ae',
    	      opacity: 0.8
    	    }
    	  }
    };

    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
    chart.draw(graphdata, options);
}

function makeQueries(keyword){
	var url = Base_url + "queries/" + keyword;
	var json;
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data){
			json = JSON.parse(data);
	    }
	}).done(function(){
		drawQueries(json);
	});
} 

function drawQueries(data){
	if(data.default.rankedList[0].rankedKeyword.length == 0){
		$('#queries_div > table').append('<tr><td></td><td>연관 검색어가 없습니다!</td></tr>');
	} else {
		for(var i = 1; i<6; i++){
			$('#queries_div > table').append('<tr><td>' + i + '</td><td>' + data.default.rankedList[0].rankedKeyword[i-1].query + '</td></tr>');
		}
	}
}

function makeTopics(keyword){
	var url = Base_url + "topics/" + keyword;
	var json;
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data){
			json = JSON.parse(data);
	    }
	}).done(function(){
		drawTopics(json);
	});
}

function drawTopics(data){
	if (data.default.rankedList[0].rankedKeyword.length == 0) {
		$('#topics_div > table').append('<tr><td></td><td>연관 검색어가 없습니다!</td></tr>');
	} else {
		for(var i = 1; i<6; i++){
			$('#topics_div > table').append('<tr><td>' + i + '</td><td>' + data.default.rankedList[0].rankedKeyword[i-1].topic.title + '</td></tr>');
		}
	}
}