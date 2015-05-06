/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.meganerd;

public class CArrayInt {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CArrayInt(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CArrayInt obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        libsndfileJNI.delete_CArrayInt(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public CArrayInt(int nelements) {
    this(libsndfileJNI.new_CArrayInt(nelements), true);
  }

  public int getitem(int index) {
    return libsndfileJNI.CArrayInt_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, int value) {
    libsndfileJNI.CArrayInt_setitem(swigCPtr, this, index, value);
  }

  public SWIGTYPE_p_int cast() {
    long cPtr = libsndfileJNI.CArrayInt_cast(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public static CArrayInt frompointer(SWIGTYPE_p_int t) {
    long cPtr = libsndfileJNI.CArrayInt_frompointer(SWIGTYPE_p_int.getCPtr(t));
    return (cPtr == 0) ? null : new CArrayInt(cPtr, false);
  }

}