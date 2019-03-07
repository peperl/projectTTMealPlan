package mx.ipn.www.finalproject.model;

public class User1Key implements java.io.Serializable, Cloneable {
    /* username */
    protected String username;

    /* username */
    public String getUsername() {
        return username;
    }

    /* username */
    public void setUsername(String username) {
        this.username = username;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        if (username != null)  
            hashCode += username.hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof User1Key))
            return false;

        User1Key key = (User1Key) obj;

        if (this.username == null) {
            if (key.username != null)
                return false;
        }
        else if (!this.username.equals(key.username)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        User1Key key = new User1Key();
        key.username = this.username;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("username").append(" = ").append(username).append("]");
        return sb.toString();
    }
}