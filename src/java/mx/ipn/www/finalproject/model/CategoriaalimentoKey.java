package mx.ipn.www.finalproject.model;

public class CategoriaalimentoKey implements java.io.Serializable, Cloneable {
    /* category_id */
    protected int categoryId;

    /* category_id */
    public int getCategoryId() {
        return categoryId;
    }

    /* category_id */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(categoryId).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof CategoriaalimentoKey))
            return false;

        CategoriaalimentoKey key = (CategoriaalimentoKey) obj;

        if (this.categoryId != key.categoryId)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        CategoriaalimentoKey key = new CategoriaalimentoKey();
        key.categoryId = this.categoryId;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("categoryId").append(" = ").append(categoryId).append("]");
        return sb.toString();
    }
}