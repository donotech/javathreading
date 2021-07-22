class HashTable100 {
    constructor() {
        this.items = Array(100);
    }
    insert(key, value) {
        this.items[key] = value;
    }
    find(key) {
        if(this.items[key]) {
            return this.items[key];
        } else {
            console.log("Item not found");
            return null;
        }
    }
    print() {
        console.log(this.items.join(","));
    }
}

ht = new HashTable100();
ht.insert(10, "ten");
ht.insert(50,"fifty");
console.log(ht.find(10));
console.log(ht.find(25));
ht.print();

