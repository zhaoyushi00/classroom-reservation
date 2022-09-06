// ========================================================================= //
//   Table Example 1
// ========================================================================= //

// Start DataTable

let ex1 = jQuery('#example1').DataTable({});

// Delete Row Datatable

$('#example1 tbody').on('click', 'a.delete span', function() {
    ex1
        .row($(this).parents('tr'))
        .remove()
        .draw();
});


// ========================================================================= //
//   Table Example 2
// ========================================================================= //

// Hide colmun Datatable 

let ex2 = jQuery('#example2').DataTable();

// Function show modal resultat patient

$('#example2 tbody').on('click', '.vue', function() {
    // getting target row data
    var data = ex2.row($(this).parents('tr')).data();
    $('.insertHere').html(
        // Adding and structuring the full data
        '<table class="table table-striped table-responsive-sm modalShowTable" width="100%"><tbody><tr><td>学号<td><td>' + data[1] + '</td></tr><tr><td>姓名<td><td>' + data[2] + '</td></tr><tr><td>班级<td><td>' + data[3] + '</td></tr><tr><td>专业<td><td>' + data[4] + '</td></tr><tr><td>年级<td><td>' + data[5] + '</td></tr><tr><td>联系方式<td><td>' + data[6] + '</td></tr></tbody></table>'
    );
    // calling the bootstrap modal
    $('#myModal').modal('show');

});

// Delete Row Datatable

$('#example2 tbody').on('click', '.delete', function() {
    ex2
        .row($(this).parents('tr'))
        .remove()
        .draw();
});

// ========================================================================= //
//   Table Example 3
// ========================================================================= //

// Billing List Table

var ex3 = jQuery('#example3').DataTable({
    dom: 'lrtip',
    "ordering": false,
    "bPaginate": true,
    "bInfo": true,
    "bSort": true,
    "lengthChange": false,

});

// Delete Row Datatable

$('#example3 tbody').on('click', '.delet', function() {
    ex3
        .row($(this).parents('tr'))
        .remove()
        .draw();
});

// Filter by Date inside datatable

var ex3 = $("#example3").DataTable();

minDateFilter = "";
maxDateFilter = "";

$("#daterange").daterangepicker();
$("#daterange").on("apply.daterangepicker", function(ev, picker) {
    minDateFilter = Date.parse(picker.startDate);
    maxDateFilter = Date.parse(picker.endDate);

    $.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
        var date = Date.parse(data[1]);

        if (
            (isNaN(minDateFilter) && isNaN(maxDateFilter)) ||
            (isNaN(minDateFilter) && date <= maxDateFilter) ||
            (minDateFilter <= date && isNaN(maxDateFilter)) ||
            (minDateFilter <= date && date <= maxDateFilter)
        ) {
            return true;
        }
        return false;
    });
    ex3.draw();
});

// Select filter inside datatable

$('.table-filter-select').on('change', function() {
    ex3.search(this.value).draw();
});

// Form search inside table

$('#myInputTextField').keyup(function() {
    ex3.search($(this).val()).draw();
})