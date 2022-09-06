$(function() {
    "use strict";

    // chart 4
    var options = {
        series: [{
            name: 'Revenue',
            data: [10, 22, 9, 12, 7, 9, 15, 19]
        }],
        chart: {
            type: 'area',
            width: 140,
            height: 65,
            sparkline: {
                enabled: true
            },
            stacked: true,
            toolbar: {
                show: false
            },
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '25%',
                endingShape: 'rounded'
            },
        },
        legend: {
            position: 'top',
            horizontalAlign: 'left',
            offsetX: 0
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            //colors: ['transparent']
        },
        fill: {
            type: 'gradient',
            gradient: {
                shade: 'dark',
                shadeIntensity: 0.15,
                gradientToColors: ['#265ed7'],
                type: 'vertical',
                inverseColors: false,
                opacityFrom: 0.1,
                opacityTo: 0.5,
                stops: [0, 50, 65, 91]
            },
        },
        colors: ["#265ed7"],
        xaxis: {
            categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug'],
        },
        tooltip: {
            theme: 'dark',
            y: {
                formatter: function(val) {
                    return "$ " + val + " "
                }
            },
            x: {
                show: false
            },
        },
    };
    var chart = new ApexCharts(document.querySelector("#chart4"), options);
    chart.render();

    // chart 5
    var options = {
        series: [{
            name: 'Visitors',
            data: [4, 10, 18, 8, 17, 9, 12, 7]
        }],
        chart: {
            type: 'area',
            width: 140,
            height: 65,
            sparkline: {
                enabled: true
            },
            stacked: true,
            toolbar: {
                show: false
            },
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '25%',
                endingShape: 'rounded'
            },
        },
        legend: {
            position: 'top',
            horizontalAlign: 'left',
            offsetX: 0
        },
        dataLabels: {
            enabled: false
        },
        stroke: {
            show: true,
            width: 2,
            //colors: ['transparent']
        },
        fill: {
            type: 'gradient',
            gradient: {
                shade: 'dark',
                shadeIntensity: 0.15,
                gradientToColors: ['#f8d62b'],
                type: 'vertical',
                inverseColors: false,
                opacityFrom: 0.1,
                opacityTo: 0.5,
                stops: [0, 50, 65, 91]
            },
        },
        colors: ["#f8d62b"],
        xaxis: {
            categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug'],
        },
        tooltip: {
            theme: 'dark',
            y: {
                formatter: function(val) {
                    return "$ " + val + " "
                }
            },
            x: {
                show: false
            },
        },
    };
    var chart = new ApexCharts(document.querySelector("#chart5"), options);
    chart.render();
});


// chart 6
var optionsLine = {
    chart: {
        foreColor: '#2b2b2b',
        height: 360,
        type: 'line',
        fontWeight: "100",
        zoom: {
            enabled: false
        },
        dropShadow: {
            enabled: true,
            top: 3,
            left: 2,
            blur: 4,
            opacity: 0.1,
        }
    },
    stroke: {
        curve: 'smooth',
        width: 3
    },
    colors: ["#7366ff", '#f73164', '#51bb25'],
    series: [{
        name: "Operation",
        data: [1, 15, 26, 20, 33, 27]
    }, {
        name: "Theraphy",
        data: [3, 33, 21, 42, 19, 32]
    }, {
        name: "Mediation",
        data: [2, 60, 18, 50, 15, 64]
    }],
    title: {
        text: 'Doctors Abilities',
        align: 'left',
        offsetY: 5,
        offsetX: 7,
    },
    subtitle: {
        text: 'Statistics',
        offsetY: 25,
        offsetX: 7,

    },
    markers: {
        size: 4,
        strokeWidth: 0,
        hover: {
            size: 7
        }
    },
    grid: {
        show: true,
        row: {
            colors: ['#f8f8f8', 'transparent'],
            opacity: 0.5
        },
        padding: {
            bottom: 0
        }
    },
    labels: ['Jan 01', 'Jan 06', 'Jan 11', 'Jan 16', 'Jan 26', 'Jan 31'],
    xaxis: {
        tooltip: {
            enabled: false
        }
    },
    legend: {
        position: 'top',
        horizontalAlign: 'right',
        offsetY: -15,
    }
}
var chartLine = new ApexCharts(document.querySelector('#chart6'), optionsLine);
chartLine.render();

// chart 7

var options = {
    series: [{
        name: 'Orders',
        data: [5, 9, 6, 10, 25, 9, 15, 8]
    }],
    chart: {
        type: 'area',
        width: 140,
        height: 65,
        sparkline: {
            enabled: true
        },
        stacked: true,
        toolbar: {
            show: false
        },
    },
    plotOptions: {
        bar: {
            horizontal: false,
            columnWidth: '25%',
            endingShape: 'rounded'
        },
    },
    legend: {
        position: 'top',
        horizontalAlign: 'left',
        offsetX: 0
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        show: true,
        width: 2,
        //colors: ['transparent']
    },
    fill: {
        type: 'gradient',
        gradient: {
            shade: 'dark',
            shadeIntensity: 0.15,
            gradientToColors: ['#51bb25'],
            type: 'vertical',
            inverseColors: false,
            opacityFrom: 0.1,
            opacityTo: 0.5,
            stops: [0, 50, 65, 91]
        },
    },
    colors: ["#51bb25"],
    xaxis: {
        categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug'],
    },
    tooltip: {
        theme: 'dark',
        y: {
            formatter: function(val) {
                return "$ " + val + " "
            }
        },
        x: {
            show: false
        },
    },
};
var chart = new ApexCharts(document.querySelector("#chart7"), options);
chart.render();

// chart 8

var options = {
    series: [{
        name: 'Net Profit',
        data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
    }, {
        name: 'Revenue',
        data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
    }, {
        name: 'Free Cash Flow',
        data: [35, 41, 36, 26, 45, 48, 52, 53, 41]
    }],
    chart: {
        foreColor: '#2b2b2b',
        type: 'bar',
        height: 400
    },
    plotOptions: {
        bar: {
            horizontal: false,
            columnWidth: '35%',
            endingShape: 'rounded'
        },
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        show: true,
        width: 2,
        colors: ['transparent']
    },
    title: {
        text: 'Column Chart',
        align: 'left',
        style: {
            fontSize: '14px'
        }
    },
    colors: ["#7366ff", '#f73164', '#51bb25'],
    xaxis: {
        categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct'],
    },
    yaxis: {
        title: {
            text: '$ (thousands)'
        }
    },
    fill: {
        opacity: 1
    },
    tooltip: {
        y: {
            formatter: function(val) {
                return "$ " + val + " thousands"
            }
        }
    }
};
var chart = new ApexCharts(document.querySelector("#chart8"), options);
chart.render();