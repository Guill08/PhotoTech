/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composantLink;

/**
 *
 * @author RDEV
 */
public abstract class AbstractEtatObject {

    protected boolean isReadOnly = false;
    protected boolean isModify = false;
    public final boolean READ_ONLY=false;
    public boolean isIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public boolean isIsModify() {
        return isModify;
    }

    public void setIsModify(boolean isModify) {
        this.isModify = isModify;
    }
    

    

}
