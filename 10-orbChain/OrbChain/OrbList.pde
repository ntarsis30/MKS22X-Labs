public class OrbList {
OrbNode first, last;

//create a fixed orb
OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
}

/**
*complete this method
*/
void add(OrbNode orb){
    //insert orb at the end of the list before the last node.
    orb.prev = last.prev;
    orb.prev.next = orb;
    orb.next = last;
    last.prev = orb;
}

void add(int xcor,OrbNode toBeAdded){
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while (current.x<=xcor && current.next!=null){
      current=current.next;
    }
    current.prev.next=toBeAdded;
    toBeAdded.prev = current.prev;
    current.prev=toBeAdded;
    toBeAdded.next=current;
}

void delete(OrbNode target){
  if (target!=null){
    target.prev.next = target.next;
    target.next.prev=target.prev;
  }
}

OrbNode getNodeAt(int x, int y){
  OrbNode current = first;
  while (current.next!=null){
    current=current.next;
    if (dist(x,y,current.x,current.y)<=current.radius){
      return current;
    }
  }
  return null;
}

/**
*complete this method
*process all nodes by running move.
*/
void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while (current!=null){
      current.move();
      current=current.next;
    }
      
}
/**
*complete this method
*Display all nodes by running their display().
*/
void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
    while (current!=null){
      current.display();
      current=current.next;
    }
}
}
