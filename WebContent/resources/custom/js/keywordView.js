$(document).ready(function(){
});

var Base_url = "https://ksm-test-dismal-coleopteran.devpack.co.kr/";
var geoObj = {
		'KR-11' : '서울특별시',
		'KR-26' : '부산광역시',
		'KR-27' : '대구광역시',
		'KR-29' : '광주광역시',
		'KR-30' : '대전광역시',
		'KR-31' : '울산광역시',
		'KR-41' : '경기도',
		'KR-42' : '강원도',
		'KR-43' : '충청북도',
		'KR-44' : '충청남도',
		'KR-45' : '전라북도',
		'KR-46' : '전라남도',
		'KR-47' : '경상북도',
		'KR-48' : '경상남도',
		'KR-49' : '제주도'
}

function makeChart(keyword) {
	var url = Base_url + "interest/" + keyword;
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
    if(data.default.timelineData.length == 0){
    	$('#chart_div').empty();
    	$('#chart_div').append("<img src='http://geekfluent.com/wp-content/uploads/2017/02/Slashed-Circle.png' width=100% height=300px/>");
    } else {
        var graphdata = new google.visualization.DataTable();
        
        graphdata.addColumn('date', 'Date');
        graphdata.addColumn('number', keyword);
	    for(var i = 0; i < data.default.timelineData.length; i++){
	    	graphdata.addRow([new Date(data.default.timelineData[i].formattedTime), data.default.timelineData[i].value[0]]);
	    }
	    var options = {
	      hAxis: {title: 'Time' },
	      vAxis: {title: '관심도' },
	      series: { 1: {curveType: 'function' }},
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

function makeGeoChart(keyword){
	var url = Base_url + "region/" + keyword;
	var json;
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data){
			json = JSON.parse(data);
	    }
	}).done(function(){
		drawGeoChart(json, keyword);
	});
}

function drawGeoChart(data, keyword){
	if(data.default.geoMapData.length == 0){
		$('#geochart_div > table').append('<tr><td></td><td>지역 인기순위가 없습니다!</td></tr>');
	} else {
		for(var i = 1; i<6; i++){
			$('#geochart_div > table').append('<tr><td>' + i + '</td><td>' + geoObj[data.default.geoMapData[i].geoCode] + '</td></tr>');
		}
	}
}
function makeNews(keyword){
	var url = Base_url + "news/" + keyword;
	var json;
	$.ajax({
		url : url,
		type : 'GET',
		success : function(data){
			json = JSON.parse(data);
		}
	}).done(function(){
		drawNews(json, keyword);
	});
}

function drawNews(data, keyword){
	if(data.items.length == 0){
		$('#news_div > table').append('<tr><td></td><td>관련 뉴스가 없습니다!</td></tr>');
	} else {
		for(var i = 1; i<6; i++){
			$('#news_div > table').append('<tr><td>' + i + '</td><td>'
					+ "<a target='_blank' href=" + data.items[i-1].link + '>' + data.items[i-1].title + '</a></td></tr>');
		}
	}
}