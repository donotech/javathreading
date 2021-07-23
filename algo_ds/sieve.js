
function sieve(n) {
    var numbers = Array(n);
    var endpoint = n; //no prime can have a factor beyond its square root
    iterations = 0;
    //initialize
    // for(var i = 0; i <= endpoint; i++) {
    //     numbers[i] = true; //assume all are primes
    // }

    for(var i = 2; i <= endpoint; i++) {
        if(numbers[i] == false) {
            continue;
        } else {
            numbers[i] = true;
        }

        for(var j = 2 * i; j < endpoint; j = j + i) {
            numbers[j] = false;
            iterations++;
        }
    }

    for(var i = 2; i <= endpoint; i++) {
        if(numbers[i]) {
            console.log(i + " is prime");
        }
    }

}

sieve(50)