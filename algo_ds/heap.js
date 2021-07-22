class MinHeap {
    constructor() {this.items = []; }
    
    printHeap() {
        console.log("Printing heap");
        console.log(this.items.join(","));
    }
    
    parentIndex(index) {return Math.floor((index - 1) / 2);}

    parent(index) { return this.items[this.parentIndex(index)]}

    leftChildIndex(index) { return index * 2 + 1; }
    leftChild(index) { return this.items[this.leftChildIndex(index)]}

    rightChildIndex(index) { return index * 2 + 2; }
    rightChild(index) { return this.items[this.rightChildIndex(index)]}

    swap(index1, index2) {
        //console.log("swapping " + index1, index2)
        var temp = this.items[index1];
        this.items[index1] = this.items[index2];
        this.items[index2] = temp;
      }

    bubbleDown(){
        var index = 0;
        while (this.leftChild(index) && this.leftChild(index) < this.items[index]) {
           var smallerIndex = this.leftChildIndex(index);
           if (this.rightChild(index)
            && this.rightChild(index) < this.items[smallerIndex]) {
                // if right is smaller, right swaps
                smallerIndex = this.rightChildrenIndex(index);
            }
            this.swap(smallerIndex, index);
            index = smallerIndex;
        }
    }

    bubbleUp() {
        var index = this.items.length - 1;
        //console.log("Buble Up ", index, " parent index ", this.parent(index));
        while (this.parent(index) && this.parent(index) > this.items[index]) {
            this.swap(this.parentIndex(index), index);
            index = this.parentIndex(index);
            //console.log(index);
        }
    }

    add_heap(item) {
        this.items[this.items.length] = item;
        this.bubbleUp();
    }

    remove_heap() {
        var item = this.items[0];
        this.items[0] = this.items[this.items.length - 1];
        this.items.pop();
        this.bubbleDown();
        return item;

    }
   
}

heap = new MinHeap();
heap.add_heap(10);
heap.add_heap(23);
heap.add_heap(36);
heap.printHeap();

heap.add_heap(18);

heap.printHeap();
heap.remove_heap(23);
heap.printHeap();