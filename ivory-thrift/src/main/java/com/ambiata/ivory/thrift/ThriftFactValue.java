/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.ambiata.ivory.thrift;

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

public class ThriftFactValue extends org.apache.thrift.TUnion<ThriftFactValue, ThriftFactValue._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftFactValue");
  private static final org.apache.thrift.protocol.TField S_FIELD_DESC = new org.apache.thrift.protocol.TField("s", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField I_FIELD_DESC = new org.apache.thrift.protocol.TField("i", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField L_FIELD_DESC = new org.apache.thrift.protocol.TField("l", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField D_FIELD_DESC = new org.apache.thrift.protocol.TField("d", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField B_FIELD_DESC = new org.apache.thrift.protocol.TField("b", org.apache.thrift.protocol.TType.BOOL, (short)5);
  private static final org.apache.thrift.protocol.TField T_FIELD_DESC = new org.apache.thrift.protocol.TField("t", org.apache.thrift.protocol.TType.STRUCT, (short)6);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    S((short)1, "s"),
    I((short)2, "i"),
    L((short)3, "l"),
    D((short)4, "d"),
    B((short)5, "b"),
    T((short)6, "t");

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
        case 1: // S
          return S;
        case 2: // I
          return I;
        case 3: // L
          return L;
        case 4: // D
          return D;
        case 5: // B
          return B;
        case 6: // T
          return T;
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

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.S, new org.apache.thrift.meta_data.FieldMetaData("s", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.I, new org.apache.thrift.meta_data.FieldMetaData("i", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.L, new org.apache.thrift.meta_data.FieldMetaData("l", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.D, new org.apache.thrift.meta_data.FieldMetaData("d", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.B, new org.apache.thrift.meta_data.FieldMetaData("b", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.T, new org.apache.thrift.meta_data.FieldMetaData("t", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftTombstone.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftFactValue.class, metaDataMap);
  }

  public ThriftFactValue() {
    super();
  }

  public ThriftFactValue(_Fields setField, Object value) {
    super(setField, value);
  }

  public ThriftFactValue(ThriftFactValue other) {
    super(other);
  }
  public ThriftFactValue deepCopy() {
    return new ThriftFactValue(this);
  }

  public static ThriftFactValue s(String value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setS(value);
    return x;
  }

  public static ThriftFactValue i(int value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setI(value);
    return x;
  }

  public static ThriftFactValue l(long value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setL(value);
    return x;
  }

  public static ThriftFactValue d(double value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setD(value);
    return x;
  }

  public static ThriftFactValue b(boolean value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setB(value);
    return x;
  }

  public static ThriftFactValue t(ThriftTombstone value) {
    ThriftFactValue x = new ThriftFactValue();
    x.setT(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case S:
        if (value instanceof String) {
          break;
        }
        throw new ClassCastException("Was expecting value of type String for field 's', but got " + value.getClass().getSimpleName());
      case I:
        if (value instanceof Integer) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Integer for field 'i', but got " + value.getClass().getSimpleName());
      case L:
        if (value instanceof Long) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Long for field 'l', but got " + value.getClass().getSimpleName());
      case D:
        if (value instanceof Double) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Double for field 'd', but got " + value.getClass().getSimpleName());
      case B:
        if (value instanceof Boolean) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Boolean for field 'b', but got " + value.getClass().getSimpleName());
      case T:
        if (value instanceof ThriftTombstone) {
          break;
        }
        throw new ClassCastException("Was expecting value of type ThriftTombstone for field 't', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case S:
          if (field.type == S_FIELD_DESC.type) {
            String s;
            s = iprot.readString();
            return s;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case I:
          if (field.type == I_FIELD_DESC.type) {
            Integer i;
            i = iprot.readI32();
            return i;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case L:
          if (field.type == L_FIELD_DESC.type) {
            Long l;
            l = iprot.readI64();
            return l;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case D:
          if (field.type == D_FIELD_DESC.type) {
            Double d;
            d = iprot.readDouble();
            return d;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case B:
          if (field.type == B_FIELD_DESC.type) {
            Boolean b;
            b = iprot.readBool();
            return b;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case T:
          if (field.type == T_FIELD_DESC.type) {
            ThriftTombstone t;
            t = new ThriftTombstone();
            t.read(iprot);
            return t;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case S:
        String s = (String)value_;
        oprot.writeString(s);
        return;
      case I:
        Integer i = (Integer)value_;
        oprot.writeI32(i);
        return;
      case L:
        Long l = (Long)value_;
        oprot.writeI64(l);
        return;
      case D:
        Double d = (Double)value_;
        oprot.writeDouble(d);
        return;
      case B:
        Boolean b = (Boolean)value_;
        oprot.writeBool(b);
        return;
      case T:
        ThriftTombstone t = (ThriftTombstone)value_;
        t.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case S:
          String s;
          s = iprot.readString();
          return s;
        case I:
          Integer i;
          i = iprot.readI32();
          return i;
        case L:
          Long l;
          l = iprot.readI64();
          return l;
        case D:
          Double d;
          d = iprot.readDouble();
          return d;
        case B:
          Boolean b;
          b = iprot.readBool();
          return b;
        case T:
          ThriftTombstone t;
          t = new ThriftTombstone();
          t.read(iprot);
          return t;
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case S:
        String s = (String)value_;
        oprot.writeString(s);
        return;
      case I:
        Integer i = (Integer)value_;
        oprot.writeI32(i);
        return;
      case L:
        Long l = (Long)value_;
        oprot.writeI64(l);
        return;
      case D:
        Double d = (Double)value_;
        oprot.writeDouble(d);
        return;
      case B:
        Boolean b = (Boolean)value_;
        oprot.writeBool(b);
        return;
      case T:
        ThriftTombstone t = (ThriftTombstone)value_;
        t.write(oprot);
        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case S:
        return S_FIELD_DESC;
      case I:
        return I_FIELD_DESC;
      case L:
        return L_FIELD_DESC;
      case D:
        return D_FIELD_DESC;
      case B:
        return B_FIELD_DESC;
      case T:
        return T_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public String getS() {
    if (getSetField() == _Fields.S) {
      return (String)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 's' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setS(String value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.S;
    value_ = value;
  }

  public int getI() {
    if (getSetField() == _Fields.I) {
      return (Integer)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'i' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setI(int value) {
    setField_ = _Fields.I;
    value_ = value;
  }

  public long getL() {
    if (getSetField() == _Fields.L) {
      return (Long)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'l' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setL(long value) {
    setField_ = _Fields.L;
    value_ = value;
  }

  public double getD() {
    if (getSetField() == _Fields.D) {
      return (Double)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'd' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setD(double value) {
    setField_ = _Fields.D;
    value_ = value;
  }

  public boolean getB() {
    if (getSetField() == _Fields.B) {
      return (Boolean)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'b' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setB(boolean value) {
    setField_ = _Fields.B;
    value_ = value;
  }

  public ThriftTombstone getT() {
    if (getSetField() == _Fields.T) {
      return (ThriftTombstone)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 't' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setT(ThriftTombstone value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.T;
    value_ = value;
  }

  public boolean isSetS() {
    return setField_ == _Fields.S;
  }


  public boolean isSetI() {
    return setField_ == _Fields.I;
  }


  public boolean isSetL() {
    return setField_ == _Fields.L;
  }


  public boolean isSetD() {
    return setField_ == _Fields.D;
  }


  public boolean isSetB() {
    return setField_ == _Fields.B;
  }


  public boolean isSetT() {
    return setField_ == _Fields.T;
  }


  public boolean equals(Object other) {
    if (other instanceof ThriftFactValue) {
      return equals((ThriftFactValue)other);
    } else {
      return false;
    }
  }

  public boolean equals(ThriftFactValue other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(ThriftFactValue other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  /**
   * If you'd like this to perform more respectably, use the hashcode generator option.
   */
  @Override
  public int hashCode() {
    return 0;
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


}
