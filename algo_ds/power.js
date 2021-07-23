
let count = 0;

function pow(a, b) {
    count = count + 1;
    if(b <= 1) {
        return a;
    } else {
        let mid = Math.floor(b/2);
        let extra = 1;
        if(b % 2 != 0.0) {
            extra = a;
        }
        subsum = pow(a,mid);
        return subsum * subsum * extra;
    }
}

let a = 3;
let b = 33;
let output = pow(a, b);
let output1 = Math.pow(a, b);
console.log("The algorithm ran " + count + " times and produced " + output + " actually should be " + output1)