<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hcharts_test页面</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath }/js/hcharts/highcharts.js"></script>
<script src="${pageContext.request.contextPath }/js/hcharts/modules/exporting.js"></script>
</head>

<body>
<script type="text/javascript">
    $(function(){
        $("#test").highcharts({
            title: {
                text: 'Browser market shares January, 2015 to May, 2015'
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'IE',
                    y: 56.33
                }, {
                    name: 'Chrome',
                    y: 24.03,
                    sliced: true,
                    selected: true
                }, {
                    name: 'Firefox',
                    y: 10.38
                }, {
                    name: 'Safari',
                    y: 4.77
                }, {
                    name: 'Opera',
                    y: 0.91
                }, {
                    name: 'Other',
                    y: 0.2
                }]
            }]
        });
    });
</script>
	<div ="test" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</body>
</html>