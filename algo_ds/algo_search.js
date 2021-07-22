function search_basic(sorted_array, number_to_search) {
    console.log('Searching for element ' + number_to_search)
    for(i = 0; i < sorted_array.length; i++) {
        element = sorted_array[i];
        console.log(element)
        if(element == number_to_search) {
            return true;
        }
    }
    return false;
}

function search_binary (sorted_array, number_to_search) {
    //We start from the mid point of the array
    //if that matches the number we found it
    //if it does not match the number and
    //   if the number is lower than the element
    //      then we eliminate the right side of the array and 
    //      search on the left side
    //   if the number is higher 
    //      then we eliminate the left side of the array and 
    //      search on the right side
    //We repeat the steps till either the array is exhausted
    //or we have found the element
    
    start_offset = 0
    end_offset = sorted_array.length -1
          
    while (start_offset <= end_offset) {
        let mid=Math.floor((start_offset + end_offset)/2);
        middle_value = sorted_array[mid];
   
        if (number_to_search === middle_value) {
            return true;
        } else if (number_to_search < middle_value) {
            end_offset = mid - 1;
        }
        else {
            start_offset = mid + 1;
        }
    }
   
    return false;
}



var arr = [1, 10, 16, 36, 59];
var found10 = search_basic(arr, 10);
console.log('found:' + found10);
var found11 = search_basic(arr, 11);
console.log(found11);

var found_b_10 = search_binary(arr, 10);
console.log('found_b_10:' + found_b_10);
var found_b_11 = search_binary(arr, 11);
console.log('found_b_11', found_b_11);

console.time('binary_search')
var found_b_10 = search_binary(arr, 10);
var duration = console.timeEnd('binary_search');
console.log(duration)
