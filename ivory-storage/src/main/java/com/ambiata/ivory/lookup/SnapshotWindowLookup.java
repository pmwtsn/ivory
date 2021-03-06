/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ambiata.ivory.lookup;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnapshotWindowLookup implements org.apache.thrift.TBase<SnapshotWindowLookup, SnapshotWindowLookup._Fields>, java.io.Serializable, Cloneable, Comparable<SnapshotWindowLookup> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SnapshotWindowLookup");

  private static final org.apache.thrift.protocol.TField WINDOW_FIELD_DESC = new org.apache.thrift.protocol.TField("window", org.apache.thrift.protocol.TType.MAP, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SnapshotWindowLookupStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SnapshotWindowLookupTupleSchemeFactory());
  }

  public Map<Integer,Integer> window; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WINDOW((short)1, "window");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // WINDOW
          return WINDOW;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WINDOW, new org.apache.thrift.meta_data.FieldMetaData("window", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SnapshotWindowLookup.class, metaDataMap);
  }

  public SnapshotWindowLookup() {
  }

  public SnapshotWindowLookup(
    Map<Integer,Integer> window)
  {
    this();
    this.window = window;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SnapshotWindowLookup(SnapshotWindowLookup other) {
    if (other.isSetWindow()) {
      Map<Integer,Integer> __this__window = new HashMap<Integer,Integer>(other.window);
      this.window = __this__window;
    }
  }

  public SnapshotWindowLookup deepCopy() {
    return new SnapshotWindowLookup(this);
  }

  @Override
  public void clear() {
    this.window = null;
  }

  public int getWindowSize() {
    return (this.window == null) ? 0 : this.window.size();
  }

  public void putToWindow(int key, int val) {
    if (this.window == null) {
      this.window = new HashMap<Integer,Integer>();
    }
    this.window.put(key, val);
  }

  public Map<Integer,Integer> getWindow() {
    return this.window;
  }

  public SnapshotWindowLookup setWindow(Map<Integer,Integer> window) {
    this.window = window;
    return this;
  }

  public void unsetWindow() {
    this.window = null;
  }

  /** Returns true if field window is set (has been assigned a value) and false otherwise */
  public boolean isSetWindow() {
    return this.window != null;
  }

  public void setWindowIsSet(boolean value) {
    if (!value) {
      this.window = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WINDOW:
      if (value == null) {
        unsetWindow();
      } else {
        setWindow((Map<Integer,Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WINDOW:
      return getWindow();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WINDOW:
      return isSetWindow();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SnapshotWindowLookup)
      return this.equals((SnapshotWindowLookup)that);
    return false;
  }

  public boolean equals(SnapshotWindowLookup that) {
    if (that == null)
      return false;

    boolean this_present_window = true && this.isSetWindow();
    boolean that_present_window = true && that.isSetWindow();
    if (this_present_window || that_present_window) {
      if (!(this_present_window && that_present_window))
        return false;
      if (!this.window.equals(that.window))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SnapshotWindowLookup other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetWindow()).compareTo(other.isSetWindow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWindow()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.window, other.window);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SnapshotWindowLookup(");
    boolean first = true;

    sb.append("window:");
    if (this.window == null) {
      sb.append("null");
    } else {
      sb.append(this.window);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SnapshotWindowLookupStandardSchemeFactory implements SchemeFactory {
    public SnapshotWindowLookupStandardScheme getScheme() {
      return new SnapshotWindowLookupStandardScheme();
    }
  }

  private static class SnapshotWindowLookupStandardScheme extends StandardScheme<SnapshotWindowLookup> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SnapshotWindowLookup struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // WINDOW
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map70 = iprot.readMapBegin();
                struct.window = new HashMap<Integer,Integer>(2*_map70.size);
                for (int _i71 = 0; _i71 < _map70.size; ++_i71)
                {
                  int _key72;
                  int _val73;
                  _key72 = iprot.readI32();
                  _val73 = iprot.readI32();
                  struct.window.put(_key72, _val73);
                }
                iprot.readMapEnd();
              }
              struct.setWindowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SnapshotWindowLookup struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.window != null) {
        oprot.writeFieldBegin(WINDOW_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, struct.window.size()));
          for (Map.Entry<Integer, Integer> _iter74 : struct.window.entrySet())
          {
            oprot.writeI32(_iter74.getKey());
            oprot.writeI32(_iter74.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SnapshotWindowLookupTupleSchemeFactory implements SchemeFactory {
    public SnapshotWindowLookupTupleScheme getScheme() {
      return new SnapshotWindowLookupTupleScheme();
    }
  }

  private static class SnapshotWindowLookupTupleScheme extends TupleScheme<SnapshotWindowLookup> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SnapshotWindowLookup struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetWindow()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetWindow()) {
        {
          oprot.writeI32(struct.window.size());
          for (Map.Entry<Integer, Integer> _iter75 : struct.window.entrySet())
          {
            oprot.writeI32(_iter75.getKey());
            oprot.writeI32(_iter75.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SnapshotWindowLookup struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map76 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.window = new HashMap<Integer,Integer>(2*_map76.size);
          for (int _i77 = 0; _i77 < _map76.size; ++_i77)
          {
            int _key78;
            int _val79;
            _key78 = iprot.readI32();
            _val79 = iprot.readI32();
            struct.window.put(_key78, _val79);
          }
        }
        struct.setWindowIsSet(true);
      }
    }
  }

}

