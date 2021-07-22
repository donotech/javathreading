class Tuple {
    constructor(key, value){
        this.key = key;
        this.value = value;
    }

    equals(key) {
        if(this.key === key) {
            return true;
        } else {
            return false;
        }
    }

    setValue(value) {
        this.value = value;
    }

    toString() {
        return "(" + this.key + "," + this.value + ")";
    }
}

class HashTable {
    
    constructor() {
        this.items = Array(100);
    }

    indexPos(key) {
        return key % (this.items.length);
    }

    insert(key, value) {
        var pos = this.indexPos(key);
        if(!this.items[pos]) {
            var arr = [];
            arr.push(new Tuple(key,value));
            this.items[pos] = arr;
        } else {
            let arr = this.items[pos];
            var found = false;
            for(var i = 0; i < arr.length; i++) {
                var tup = arr[i];
                if(tup.equals(key)) {
                    tup.setValue(value); //replacing
                    found = true;
                    break;
                }
            }

            if(!found) {
                arr.push(new Tuple(key, value));
            }   
        }
    }

    find(key) {
        var pos = this.indexPos(key);
        if(this.items[pos]) {
            let arr = this.items[pos];
            for(var i = 0; i < arr.length; i++) {
                var tup = arr[i];
                if(tup.equals(key)) {
                    return tup.value; 
                }
            }

            console.log(key + " key not found");
            return null;
 
        } else {
            console.log(key + " key not found");
            return null;
        }
    }
    print() {
        console.log(this.items.join(","));
    }
}

ht = new HashTable();
ht.insert(10, "ten");
ht.insert(50,"fifty");
console.log(ht.find(10));
console.log(ht.find(25));
ht.print();
ht.insert(10,"newten");
ht.insert(110, "hundred10");
ht.print();
console.log(ht.find(10));
console.log(ht.find(110));

