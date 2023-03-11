

public class LinkedListBasedSet  implements IntSet {
	
	private IntNode head=null;
	private int size;
	
	
	@Override
	public int size() { 
		int count=0;
		IntNode walk=head;
		
		while(walk!=null) {
			  count++;
			  walk=walk.next;			
		}
		return count;
	}

	@Override
	public boolean isEmpty() { 

		if(head==null) {
			System.out.print("sdsfs");
			return true;		
				}
			
		return false;
	}

	@Override
	public boolean add(int newEntry) {  
		IntNode nd = new IntNode(newEntry);
		
		if (head== null) {
			head=nd;
		}		
		else {
			
			IntNode walk=head;
			
			while(walk!=null){
				if(walk.data==nd.data) {				
					break;}	
				
				else {
					if(walk.next!=null) {
						walk=walk.next;}
					
					else {
						walk.next=nd;}					
				}								
			}									
		}

		return false;
	}

	@Override
	public boolean remove(int anEntry) { 
		IntNode walk= head;
		IntNode prev= null;
		
		if(head.data == anEntry)
		{
			head = head.next;
			return false;
			
		}
		while(walk!=null) {
			if(walk.data==anEntry) {
				prev.next=walk.next;
				break;
			}
		prev=walk;	
		walk=walk.next;	
		}
			return false;
	}

	@Override
	public void clear() {  
		this.size=0;		
	}

	
	@Override
	public boolean contains(int anEntry) {
	IntNode walk = head;
	
	while(walk!=null) {
		if(walk.data==anEntry) {
			return true;
		}
		walk=walk.next;
	} 
	
		return false;
	}
	
	

	
	
	@Override
	public int[] toArray() {
		IntNode walk =head;				
		int []items=new int[this.size()];
		
		for(int i=0;i<this.size();i++){
			items[i]= walk.data;
			walk=walk.next;		
		}
		return items;
	}

	
	
	@Override
	public IntSet union(IntSet arg) {
		IntNode walk=head;
		IntSet set4=new LinkedListBasedSet();
		set4=arg;
		while(walk!=null) {
			if(!set4.contains(walk.data)) {
				set4.add(walk.data);
			}
			walk=walk.next;
		}
		
		return set4;
	}

	@Override
	
		public IntSet intersection(IntSet arg) { 
		IntNode walk=head;
		IntSet set3=new LinkedListBasedSet();
			while(walk!=null) {
				if(arg.contains(walk.data)) {
					set3.add(walk.data);
				}
				walk=walk.next;
			}
			return set3;
		}

	@Override
	public IntSet difference(IntSet arg) {		//remove çalýþmadýðý için çalýþmýyor

		IntNode walk =head;
		IntSet set5=new LinkedListBasedSet();
		set5=arg;
		while(walk!=null) {
			if(arg.contains(walk.data)) {
				set5.remove(walk.data);			
			}
			
			walk=walk.next;
		}
		
		return set5;
	}

	 @Override
	 public String toString() {			
		 StringBuilder items = new StringBuilder("");		
		 int count=0;
			IntNode walk=head;

			while(walk!=null) {
				items.append("\n"+count+". "+walk.data);
					count++;
				  walk=walk.next;	
				  
			}
			return items.toString();
	    }
	
}
