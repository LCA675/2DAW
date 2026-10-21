// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = "'Nunito Sans', system-ui, sans-serif";
Chart.defaults.global.defaultFontColor = '#3A1E0C';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Direct", "Referral", "Social"],
    datasets: [{
      data: [55, 30, 15],
      backgroundColor: ['#843C05', '#592A10', '#9A5300'],
      hoverBackgroundColor: ['#592A10', '#3A1E0C', '#E78607'],
      hoverBorderColor: "rgba(248, 230, 204, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#3A1E0C",
      borderColor: '#F8E6CC',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});
