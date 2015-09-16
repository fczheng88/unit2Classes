/**
* Write a description of class Door here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Door
{
/** The status for the door tells whether or not the door is open or closed) */
private boolean isOpen;
private String name;

/**
* Default constructor for objects of class Door
* @param String newName is the name of the door
* @param boolean tf is the status of the door as true = "open" or false = "close"
*/
public Door(String newName, boolean tf)
{
this.isOpen = tf;

this.name = newName;
}

/**
* This method will open the door
*
* @post statusDoor is set to "open"
* */
public void openDoor()
{
isOpen = true;
}

/** This method give a new name to the door
*
* @post sets a new name
* @param String newName is the new name of the door
*/
public void setName(String newName)
{
this.name = newName;
}

/**
* This method will close the door
*
* @post statusDoor is set to "close"
*/
public void closeDoor()
{
isOpen = false;
}

/**
*This method returns the status of the door as true or false
*@return boolean true or false (open or closed)
*/
public boolean getStatus()
{
return isOpen;
}
/**
* returns the name of the door
*
* @pre door has name
* @return String name of the door
*/
public String getName()
{
return this.name;
}

}