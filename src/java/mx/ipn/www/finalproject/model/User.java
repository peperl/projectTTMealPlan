package mx.ipn.www.finalproject.model;

/*
 * For Table user
 */
public class User implements java.io.Serializable, Cloneable {
    private UserKey _key = new UserKey();

    /* username, PK */
    protected String username;

    /* email */
    protected String email;

    /* password */
    protected String password;

    /* create_time */
    protected java.sql.Timestamp createTime;

    /* Return the key object. */
    public UserKey getKeyObject() {
        return _key;
    }

    /* username, PK */
    public String getUsername() {
        return username;
    }

    /* username, PK */
    public void setUsername(String username) {
        this.username = username;
        _key.setUsername(username);
    }

    /* email */
    public String getEmail() {
        return email;
    }

    /* email */
    public void setEmail(String email) {
        this.email = email;
    }

    /* password */
    public String getPassword() {
        return password;
    }

    /* password */
    public void setPassword(String password) {
        this.password = password;
    }

    /* create_time */
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    /* create_time */
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof User))
            return false;

        User bean = (User) obj;

        if (this.username == null) {
            if (bean.username != null)
                return false;
        }
        else if (!this.username.equals(bean.username)) 
            return false;

        if (this.email == null) {
            if (bean.email != null)
                return false;
        }
        else if (!this.email.equals(bean.email)) 
            return false;

        if (this.password == null) {
            if (bean.password != null)
                return false;
        }
        else if (!this.password.equals(bean.password)) 
            return false;

        if (this.createTime == null) {
            if (bean.createTime != null)
                return false;
        }
        else if (!this.createTime.equals(bean.createTime)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        User bean = new User();
        bean.username = this.username;
        bean.email = this.email;
        bean.password = this.password;
        if (this.createTime != null)
            bean.createTime = (java.sql.Timestamp) this.createTime.clone();
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("username").append(" = ").append(username).append("]").append(sep);
        sb.append("[").append("email").append(" = ").append(email).append("]").append(sep);
        sb.append("[").append("password").append(" = ").append(password).append("]").append(sep);
        sb.append("[").append("createTime").append(" = ").append(createTime).append("]").append(sep);
        return sb.toString();
    }
}