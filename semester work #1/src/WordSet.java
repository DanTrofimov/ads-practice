public class WordSet {
    // WordSet properties
    protected Node head;

    // node of the WordSet
    private class Node {

        private String data;
        private Node next;

        public Node(){
            this.data = null;
            this.next = null;
        }

        public Node(String data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(String data){
            this.data = data;
            this.next = null;
        }

        public String getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setData(String data){
            this.data = data;
        }
    }

    // constructors
    public WordSet(){
        this.head = null;
    }

    // constructor #1
    public WordSet(String[] arr) {
        this.head = null;
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }

    // constructor #2 which merges two WordSets
    public WordSet(WordSet w1,WordSet w2){
        this.head = w1.head;
        Node e1 = w1.head;
        while (e1.getNext()!=null){
            e1 = e1.getNext();
        }
        e1.setNext(w2.head);
    }

    // toSting WordSet
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node item = this.head;
        str.append(item.getData());
        while (item.getNext()!=null){
            str.append("->");
            item = item.getNext();
            str.append(item.getData());
        }
        return str.toString();
    }

    // deletes word from the WordSet
    public void delete(String word){
        if (word.equals(this.head.getData())){
            head = this.head.getNext();
        }
        Node del = this.head.getNext();
        Node l = this.head;
        while (del.getNext()!=null){
            if (del.getData().equals(word)){
                break;
            }
            l = del;
            del = del.getNext();
        }
        if (del.getData().equals(word)){
            l.setNext(del.getNext());
        }
    }

    // deletes palindrome from the WordSet
    public void removePalindrom(){
        while (this.checkPolindrom(this.head.getData())){
            this.head = head.getNext();
        }
        Node del = this.head.getNext();
        Node l = this.head;
        while (del.getNext()!=null){
            if (this.checkPolindrom(del.getData())){
                l.setNext(del.getNext());
                del = del.getNext();
            } else {
                l = del;
                del = del.getNext();
            }
        }
        if (this.checkPolindrom(del.getData())) {
            l.setNext(null);
        }
    }

    // check to the palindrome
    private boolean checkPolindrom(String str){
        for (int i = 0;i<(int) str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    // inserts new Node in the WordSet
    public void insert(String word) {
        if (!contains(word)) {
            if (this.head == null) {
                this.head = new Node(word, null);
            } else {
                if (this.head.data.compareTo(word) > 0) { // if (compare(this.head.data, word) > 0)
                        Node buffer = this.head;
                        this.head = new Node(word, buffer);
                        return;
                } else {
                    Node nextNode = this.head;
                    while (nextNode.next != null) {
                        if (word.compareTo(nextNode.next.data) < 0) { // if (compare(word, nextNode.next.data))
                            Node newNode = new Node(word, nextNode.next);
                            nextNode.next = newNode;
                            return;
                        } else nextNode = nextNode.next;
                    }
                    Node newNode = new Node(word, null);
                    nextNode.next = newNode;
                }
            }
        }
    }

    // true - includes; false - not
    public boolean contains(String word) {
        if (this.head == null) {
            return false;
        } else {
            if (word.equals(this.head.data)) {
                return true;
            } else {
                Node nextNode = this.head;
                while (nextNode != null) {
                    if (word.equals(nextNode.getData())) {
                        return true;
                    } else {
                        nextNode = nextNode.getNext();
                    }
                }
                return false;
            }
        }
    }

    // returns new WordSet with words with length - len
    public WordSet newWordSetByWordLength(int len) {
        WordSet result = new WordSet();
        if (this.head == null) {
            // try to fix NullPointerExsception
            return null;
        } else {
            Node nextNode = this.head;
            while (nextNode != null) {
                if (nextNode.data.length() == len) {
                    result.insert(nextNode.data);
                }
                nextNode = nextNode.next;
            }
            return result;
        }
    }

    // sort words to by first char to consonants or vowels
    public WordSet [] vowelDivide() {
        WordSet[] result = new WordSet[2];
        result[0] = new WordSet();
        result[1] = new WordSet();
        if (this.head == null) {
            // try to fix NullPointerExsception
            return null;
        } else {
            Character[] vowels = new Character[] {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'};
            Node nextNode = this.head;
            boolean flag;
            while (nextNode != null) {
                flag = true;
                for (int i = 0; i < vowels.length; i++) {
                    if (nextNode.data.charAt(0) == vowels[i]) {
                        // add to vowels-words
                        result[0].insert(nextNode.data);
                        flag = false;
                    } else continue;
                }
                // add to consonants-words
                if (flag) result[1].insert(nextNode.data);
                nextNode = nextNode.next;
            }
            return result;
        }
    }
}
