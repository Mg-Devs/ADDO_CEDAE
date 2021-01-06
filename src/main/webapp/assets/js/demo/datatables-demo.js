// Select the node that will be observed for mutations
const targetNode = document.getElementById('content-page');

// Options for the observer (which mutations to observe)
const config = { attributes: true, childList: true, subtree: true };

// Callback function to execute when mutations are observed
const callback = function(mutationsList, observer) {
    $('#dataTable').DataTable();
};

// Create an observer instance linked to the callback function
const observer = new MutationObserver(callback);

// Start observing the target node for configured mutations
observer.observe(targetNode, config);

//IF it is started
// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
});