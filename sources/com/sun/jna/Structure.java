package com.sun.jna;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class Structure {
    public static final int ALIGN_DEFAULT = 0;
    public static final int ALIGN_GNUC = 2;
    public static final int ALIGN_MSVC = 3;
    public static final int ALIGN_NONE = 1;
    protected static final int CALCULATE_SIZE = -1;
    private int actualAlignType;
    private int alignType;
    private Structure[] array;
    private boolean autoRead;
    private boolean autoWrite;
    private String encoding;
    private Pointer memory;
    private final Map<String, NativeStringTracking> nativeStrings;
    private boolean readCalled;
    private int size;
    private int structAlignment;
    private Map<String, StructField> structFields;
    private long typeInfo;
    private TypeMapper typeMapper;
    private static final Logger LOG = Logger.getLogger(Structure.class.getName());
    static final ReentrantReadWriteLock layoutInfoLock = new ReentrantReadWriteLock();
    static final ReentrantReadWriteLock fieldOrderLock = new ReentrantReadWriteLock();
    static final ReentrantReadWriteLock fieldListLock = new ReentrantReadWriteLock();
    static final ReentrantReadWriteLock validationLock = new ReentrantReadWriteLock();
    static final Map<Class<?>, LayoutInfo> layoutInfo = new WeakHashMap();
    static final Map<Class<?>, List<String>> fieldOrder = new WeakHashMap();
    static final Map<Class<?>, List<Field>> fieldList = new WeakHashMap();
    static final Map<Class<?>, Boolean> validationMap = new WeakHashMap();
    private static final ThreadLocal<Map<Pointer, Structure>> reads = new ThreadLocal<Map<Pointer, Structure>>() { // from class: com.sun.jna.Structure.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Map<Pointer, Structure> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Set<Structure>> busy = new ThreadLocal<Set<Structure>>() { // from class: com.sun.jna.Structure.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Set<Structure> initialValue() {
            return new StructureSet();
        }
    };
    private static final Pointer PLACEHOLDER_MEMORY = new Pointer(0) { // from class: com.sun.jna.Structure.3
        @Override // com.sun.jna.Pointer
        public Pointer share(long j3, long j4) {
            return this;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AutoAllocated extends Memory {
        public AutoAllocated(int i3) {
            super(i3);
            super.clear();
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return "auto-" + super.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ByReference {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ByValue {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @FieldOrder({"size", "alignment", "type", "elements"})
    static class FFIType extends Structure {
        private static final int FFI_TYPE_STRUCT = 13;
        private static final Map<Pointer, FFIType> ffiTypeInfo;
        private static final Map<Class, Map<Integer, FFIType>> typeInfoMap = new WeakHashMap();
        private static final Map<Class, FFIType> unionHelper = new WeakHashMap();
        public short alignment;
        public Pointer elements;
        public size_t size;
        public short type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class FFITypes {
            private static Pointer ffi_type_double;
            private static Pointer ffi_type_float;
            private static Pointer ffi_type_longdouble;
            private static Pointer ffi_type_pointer;
            private static Pointer ffi_type_sint16;
            private static Pointer ffi_type_sint32;
            private static Pointer ffi_type_sint64;
            private static Pointer ffi_type_sint8;
            private static Pointer ffi_type_uint16;
            private static Pointer ffi_type_uint32;
            private static Pointer ffi_type_uint64;
            private static Pointer ffi_type_uint8;
            private static Pointer ffi_type_void;

            private FFITypes() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class size_t extends IntegerType {
            private static final long serialVersionUID = 1;

            public size_t() {
                this(0L);
            }

            public size_t(long j3) {
                super(Native.SIZE_T_SIZE, j3);
            }
        }

        static {
            HashMap map = new HashMap();
            ffiTypeInfo = map;
            if (Native.POINTER_SIZE == 0) {
                throw new Error("Native library not initialized");
            }
            if (FFITypes.ffi_type_void == null) {
                throw new Error("FFI types not initialized");
            }
            map.put(FFITypes.ffi_type_void, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_void));
            map.put(FFITypes.ffi_type_float, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_float));
            map.put(FFITypes.ffi_type_double, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_double));
            map.put(FFITypes.ffi_type_longdouble, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_longdouble));
            map.put(FFITypes.ffi_type_uint8, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint8));
            map.put(FFITypes.ffi_type_sint8, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint8));
            map.put(FFITypes.ffi_type_uint16, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint16));
            map.put(FFITypes.ffi_type_sint16, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint16));
            map.put(FFITypes.ffi_type_uint32, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint32));
            map.put(FFITypes.ffi_type_sint32, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint32));
            map.put(FFITypes.ffi_type_uint64, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint64));
            map.put(FFITypes.ffi_type_sint64, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint64));
            map.put(FFITypes.ffi_type_pointer, (FFIType) Structure.newInstance(FFIType.class, FFITypes.ffi_type_pointer));
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((FFIType) it.next()).read();
            }
            Map<Pointer, FFIType> map2 = ffiTypeInfo;
            storeTypeInfo(Void.TYPE, map2.get(FFITypes.ffi_type_void));
            storeTypeInfo(Void.class, map2.get(FFITypes.ffi_type_void));
            storeTypeInfo(Float.TYPE, map2.get(FFITypes.ffi_type_float));
            storeTypeInfo(Float.class, map2.get(FFITypes.ffi_type_float));
            storeTypeInfo(Double.TYPE, map2.get(FFITypes.ffi_type_double));
            storeTypeInfo(Double.class, map2.get(FFITypes.ffi_type_double));
            storeTypeInfo(Long.TYPE, map2.get(FFITypes.ffi_type_sint64));
            storeTypeInfo(Long.class, map2.get(FFITypes.ffi_type_sint64));
            storeTypeInfo(Integer.TYPE, map2.get(FFITypes.ffi_type_sint32));
            storeTypeInfo(Integer.class, map2.get(FFITypes.ffi_type_sint32));
            storeTypeInfo(Short.TYPE, map2.get(FFITypes.ffi_type_sint16));
            storeTypeInfo(Short.class, map2.get(FFITypes.ffi_type_sint16));
            FFIType fFIType = map2.get(Native.WCHAR_SIZE == 2 ? FFITypes.ffi_type_uint16 : FFITypes.ffi_type_uint32);
            storeTypeInfo(Character.TYPE, fFIType);
            storeTypeInfo(Character.class, fFIType);
            storeTypeInfo(Byte.TYPE, map2.get(FFITypes.ffi_type_sint8));
            storeTypeInfo(Byte.class, map2.get(FFITypes.ffi_type_sint8));
            storeTypeInfo(Pointer.class, map2.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(String.class, map2.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(WString.class, map2.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(Boolean.TYPE, map2.get(FFITypes.ffi_type_uint32));
            storeTypeInfo(Boolean.class, map2.get(FFITypes.ffi_type_uint32));
        }

        public FFIType(FFIType fFIType) {
            this.type = (short) 13;
            this.size = fFIType.size;
            this.alignment = fFIType.alignment;
            this.type = fFIType.type;
            this.elements = fFIType.elements;
        }

        static FFIType get(Object obj) {
            FFIType typeInfo;
            if (obj != null) {
                return obj instanceof Class ? get(null, (Class) obj) : get(obj, obj.getClass());
            }
            synchronized (typeInfoMap) {
                typeInfo = getTypeInfo(Pointer.class, 0);
            }
            return typeInfo;
        }

        private static FFIType getTypeInfo(Class cls, int i3) {
            Map<Integer, FFIType> map = typeInfoMap.get(cls);
            if (map != null) {
                return map.get(Integer.valueOf(i3));
            }
            return null;
        }

        private void init(Pointer[] pointerArr) {
            Memory memory = new Memory(Native.POINTER_SIZE * pointerArr.length);
            this.elements = memory;
            memory.write(0L, pointerArr, 0, pointerArr.length);
            write();
        }

        private static boolean isFloatType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_float) || pointer.equals(FFITypes.ffi_type_double);
        }

        private static boolean isIntegerType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_uint8) || pointer.equals(FFITypes.ffi_type_sint8) || pointer.equals(FFITypes.ffi_type_uint16) || pointer.equals(FFITypes.ffi_type_sint16) || pointer.equals(FFITypes.ffi_type_uint32) || pointer.equals(FFITypes.ffi_type_sint32) || pointer.equals(FFITypes.ffi_type_uint64) || pointer.equals(FFITypes.ffi_type_sint64) || pointer.equals(FFITypes.ffi_type_pointer);
        }

        private static void storeTypeInfo(Class cls, FFIType fFIType) {
            storeTypeInfo(cls, 0, fFIType);
        }

        private static void storeTypeInfo(Class cls, int i3, FFIType fFIType) {
            Map<Class, Map<Integer, FFIType>> map = typeInfoMap;
            synchronized (map) {
                try {
                    Map<Integer, FFIType> map2 = map.get(cls);
                    if (map2 == null) {
                        map2 = new HashMap<>();
                        map.put(cls, map2);
                    }
                    map2.put(Integer.valueOf(i3), fFIType);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FFIType() {
            this.type = (short) 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FFIType get(Object obj, Class<?> cls) {
            ToNativeConverter toNativeConverter;
            TypeMapper typeMapper = Native.getTypeMapper(cls);
            if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
                cls = toNativeConverter.nativeType();
            }
            Map<Class, Map<Integer, FFIType>> map = typeInfoMap;
            synchronized (map) {
                try {
                    FFIType typeInfo = getTypeInfo(cls, cls.isArray() ? Array.getLength(obj) : 0);
                    if (typeInfo != null) {
                        return typeInfo;
                    }
                    if ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls)) {
                        map.put(cls, map.get(Pointer.class));
                        return map.get(Pointer.class).get(0);
                    }
                    if (Structure.class.isAssignableFrom(cls)) {
                        if (obj == null) {
                            obj = Structure.newInstance(cls, Structure.PLACEHOLDER_MEMORY);
                        }
                        if (ByReference.class.isAssignableFrom(cls)) {
                            map.put(cls, map.get(Pointer.class));
                            return map.get(Pointer.class).get(0);
                        }
                        FFIType fFIType = new FFIType((Structure) obj);
                        storeTypeInfo(cls, fFIType);
                        return fFIType;
                    }
                    if (NativeMapped.class.isAssignableFrom(cls)) {
                        NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
                        return get(nativeMappedConverter.toNative(obj, new ToNativeContext()), nativeMappedConverter.nativeType());
                    }
                    if (cls.isArray()) {
                        FFIType fFIType2 = new FFIType(obj, cls);
                        storeTypeInfo(cls, Array.getLength(obj), fFIType2);
                        return fFIType2;
                    }
                    throw new IllegalArgumentException("Unsupported type " + cls);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FFIType(Structure structure) {
            Pointer[] pointerArr;
            int i3;
            this.type = (short) 13;
            structure.ensureAllocated(true);
            int i4 = 0;
            if (structure instanceof Union) {
                int i5 = 0;
                boolean z2 = false;
                FFIType fFIType = null;
                for (StructField structField : structure.fields().values()) {
                    FFIType fieldTypeInfo = structure.getFieldTypeInfo(structField);
                    z2 = isIntegerType(fieldTypeInfo) ? true : z2;
                    if (fFIType == null || i5 < (i3 = structField.size) || (i5 == i3 && Structure.class.isAssignableFrom(structField.type))) {
                        i5 = structField.size;
                        fFIType = fieldTypeInfo;
                    }
                }
                if (((Platform.isIntel() && Platform.is64Bit() && !Platform.isWindows()) || Platform.isARM() || Platform.isLoongArch()) && z2 && isFloatType(fFIType)) {
                    FFIType fFIType2 = new FFIType(fFIType);
                    if (fFIType2.size.intValue() == 4) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint32).type;
                    } else if (fFIType2.size.intValue() == 8) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint64).type;
                    }
                    fFIType2.write();
                    fFIType = fFIType2;
                }
                pointerArr = new Pointer[]{fFIType.getPointer(), null};
                unionHelper.put(structure.getClass(), fFIType);
            } else {
                pointerArr = new Pointer[structure.fields().size() + 1];
                Iterator<StructField> it = structure.fields().values().iterator();
                while (it.hasNext()) {
                    pointerArr[i4] = structure.getFieldTypeInfo(it.next()).getPointer();
                    i4++;
                }
            }
            init(pointerArr);
            write();
        }

        public FFIType(Object obj, Class<?> cls) {
            this.type = (short) 13;
            int length = Array.getLength(obj);
            Pointer[] pointerArr = new Pointer[length + 1];
            Pointer pointer = get(null, cls.getComponentType()).getPointer();
            for (int i3 = 0; i3 < length; i3++) {
                pointerArr[i3] = pointer;
            }
            init(pointerArr);
            write();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldOrder {
        String[] value();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LayoutInfo {
        private int alignType;
        private int alignment;
        private final Map<String, StructField> fields;
        private int size;
        private TypeMapper typeMapper;
        private boolean variable;

        private LayoutInfo() {
            this.size = -1;
            this.alignment = 1;
            this.fields = Collections.synchronizedMap(new LinkedHashMap());
            this.alignType = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NativeStringTracking {
        private NativeString peer;
        private final Object value;

        NativeStringTracking(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class StructField {
        public FromNativeContext context;
        public Field field;
        public boolean isReadOnly;
        public boolean isVolatile;
        public String name;
        public FromNativeConverter readConverter;
        public Class<?> type;
        public ToNativeConverter writeConverter;
        public int size = -1;
        public int offset = -1;

        protected StructField() {
        }

        public String toString() {
            return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StructureSet extends AbstractCollection<Structure> implements Set<Structure> {
        private int count;
        Structure[] elements;

        StructureSet() {
        }

        private void ensureCapacity(int i3) {
            Structure[] structureArr = this.elements;
            if (structureArr == null) {
                this.elements = new Structure[(i3 * 3) / 2];
            } else if (structureArr.length < i3) {
                Structure[] structureArr2 = new Structure[(i3 * 3) / 2];
                System.arraycopy(structureArr, 0, structureArr2, 0, structureArr.length);
                this.elements = structureArr2;
            }
        }

        private int indexOf(Structure structure) {
            for (int i3 = 0; i3 < this.count; i3++) {
                Structure structure2 = this.elements[i3];
                if (structure == structure2 || (structure.getClass() == structure2.getClass() && structure.size() == structure2.size() && structure.getPointer().equals(structure2.getPointer()))) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return indexOf((Structure) obj) != -1;
        }

        public Structure[] getElements() {
            return this.elements;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Structure> iterator() {
            int i3 = this.count;
            Structure[] structureArr = new Structure[i3];
            if (i3 > 0) {
                System.arraycopy(this.elements, 0, structureArr, 0, i3);
            }
            return Arrays.asList(structureArr).iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iIndexOf = indexOf((Structure) obj);
            if (iIndexOf == -1) {
                return false;
            }
            int i3 = this.count - 1;
            this.count = i3;
            if (i3 >= 0) {
                Structure[] structureArr = this.elements;
                structureArr[iIndexOf] = structureArr[i3];
                structureArr[i3] = null;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Structure structure) {
            if (contains(structure)) {
                return false;
            }
            ensureCapacity(this.count + 1);
            Structure[] structureArr = this.elements;
            int i3 = this.count;
            this.count = i3 + 1;
            structureArr[i3] = structure;
            return true;
        }
    }

    protected Structure() {
        this(0);
    }

    public static /* synthetic */ List a(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (!cls.equals(Structure.class)) {
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
                    arrayList2.add(field);
                }
            }
            arrayList.addAll(0, arrayList2);
            arrayList2.clear();
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private int addPadding(int i3) {
        return addPadding(i3, this.structAlignment);
    }

    public static void autoRead(Structure[] structureArr) {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoRead();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoRead();
            }
        }
    }

    public static void autoWrite(Structure[] structureArr) {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoWrite();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoWrite();
            }
        }
    }

    private Class<?> baseClass() {
        return (((this instanceof ByReference) || (this instanceof ByValue)) && Structure.class.isAssignableFrom(getClass().getSuperclass())) ? getClass().getSuperclass() : getClass();
    }

    static Set<Structure> busy() {
        return busy.get();
    }

    public static /* synthetic */ Boolean c(Structure structure, Class cls) {
        for (Field field : structure.getFieldList()) {
            structure.validateField(field.getName(), field.getType());
        }
        return Boolean.TRUE;
    }

    public static List<String> createFieldsOrder(List<String> list, String... strArr) {
        return createFieldsOrder(list, (List<String>) Arrays.asList(strArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LayoutInfo deriveLayout(boolean z2, boolean z3) {
        LayoutInfo layoutInfo2;
        Class<?> clsNativeType;
        List<Field> fields = getFields(z2);
        LayoutInfo layoutInfo3 = null;
        Object[] objArr = 0;
        if (fields == null) {
            return null;
        }
        LayoutInfo layoutInfo4 = new LayoutInfo();
        layoutInfo4.alignType = this.alignType;
        layoutInfo4.typeMapper = this.typeMapper;
        boolean z4 = true;
        int iMax = 0;
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            if (type.isArray()) {
                layoutInfo4.variable = true;
            }
            StructField structField = new StructField();
            structField.isVolatile = Modifier.isVolatile(modifiers);
            boolean zIsFinal = Modifier.isFinal(modifiers);
            structField.isReadOnly = zIsFinal;
            if (zIsFinal) {
                if (!Platform.RO_FIELDS) {
                    throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + getClass() + ")");
                }
                field.setAccessible(true);
            }
            structField.field = field;
            structField.name = field.getName();
            structField.type = type;
            if (Callback.class.isAssignableFrom(type) && !type.isInterface()) {
                throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }
            if (type.isArray() && Structure.class.equals(type.getComponentType())) {
                throw new IllegalArgumentException("Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined");
            }
            if (Modifier.isPublic(field.getModifiers())) {
                Object fieldValue = getFieldValue(structField.field);
                if (fieldValue == null && type.isArray()) {
                    if (z2) {
                        throw new IllegalStateException("Array fields must be initialized");
                    }
                    return layoutInfo3;
                }
                if (NativeMapped.class.isAssignableFrom(type)) {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(type);
                    clsNativeType = nativeMappedConverter.nativeType();
                    structField.writeConverter = nativeMappedConverter;
                    structField.readConverter = nativeMappedConverter;
                    structField.context = new StructureReadContext(this, field);
                    layoutInfo2 = layoutInfo3;
                } else {
                    TypeMapper typeMapper = this.typeMapper;
                    if (typeMapper != null) {
                        ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(type);
                        FromNativeConverter fromNativeConverter = this.typeMapper.getFromNativeConverter(type);
                        if (toNativeConverter == null || fromNativeConverter == null) {
                            layoutInfo2 = layoutInfo3;
                            if (toNativeConverter != null || fromNativeConverter != null) {
                                throw new IllegalArgumentException("Structures require bidirectional type conversion for " + type);
                            }
                        } else {
                            layoutInfo2 = layoutInfo3;
                            fieldValue = toNativeConverter.toNative(fieldValue, new StructureWriteContext(this, structField.field));
                            Class cls = fieldValue != null ? fieldValue.getClass() : Pointer.class;
                            structField.writeConverter = toNativeConverter;
                            structField.readConverter = fromNativeConverter;
                            structField.context = new StructureReadContext(this, field);
                            clsNativeType = cls;
                        }
                    } else {
                        layoutInfo2 = layoutInfo3;
                    }
                    clsNativeType = type;
                }
                if (fieldValue == null) {
                    fieldValue = initializeField(structField.field, type);
                }
                try {
                    structField.size = getNativeSize(clsNativeType, fieldValue);
                    int nativeAlignment = getNativeAlignment(clsNativeType, fieldValue, z4);
                    if (nativeAlignment == 0) {
                        throw new Error("Field alignment is zero for field '" + structField.name + "' within " + getClass());
                    }
                    layoutInfo4.alignment = Math.max(layoutInfo4.alignment, nativeAlignment);
                    int i3 = iMax % nativeAlignment;
                    if (i3 != 0) {
                        iMax += nativeAlignment - i3;
                    }
                    if (this instanceof Union) {
                        structField.offset = 0;
                        iMax = Math.max(iMax, structField.size);
                    } else {
                        structField.offset = iMax;
                        iMax += structField.size;
                    }
                    layoutInfo4.fields.put(structField.name, structField);
                } catch (IllegalArgumentException e3) {
                    if (!z2 && this.typeMapper == null) {
                        return layoutInfo2;
                    }
                    throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + e3.getMessage(), e3);
                }
            } else {
                layoutInfo2 = layoutInfo3;
            }
            z4 = false;
            layoutInfo3 = layoutInfo2;
        }
        if (iMax <= 0) {
            throw new IllegalArgumentException("Structure " + getClass() + " has unknown or zero size (ensure all fields are public)");
        }
        int iAddPadding = addPadding(iMax, layoutInfo4.alignment);
        if ((this instanceof ByValue) && !z3) {
            getTypeInfo();
        }
        layoutInfo4.size = iAddPadding;
        return layoutInfo4;
    }

    private List<String> fieldOrder() {
        Class<?> cls = getClass();
        ReentrantReadWriteLock reentrantReadWriteLock = fieldOrderLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            Map<Class<?>, List<String>> map = fieldOrder;
            List<String> list = map.get(cls);
            if (list != null) {
                reentrantReadWriteLock.readLock().unlock();
                return list;
            }
            reentrantReadWriteLock.readLock().unlock();
            reentrantReadWriteLock.writeLock().lock();
            try {
                List<String> listComputeIfAbsent = map.computeIfAbsent(cls, new java.util.function.Function() { // from class: com.sun.jna.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.f93449a.getFieldOrder();
                    }
                });
                reentrantReadWriteLock.writeLock().unlock();
                return listComputeIfAbsent;
            } catch (Throwable th) {
                fieldOrderLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            fieldOrderLock.readLock().unlock();
            throw th2;
        }
    }

    private String format(Class<?> cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    private static <T> Constructor<T> getPointerConstructor(Class<T> cls) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(Pointer.class)) {
                return constructor;
            }
        }
        return null;
    }

    private Object initializeField(Field field, Class<?> cls) {
        if (!Structure.class.isAssignableFrom(cls) || ByReference.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                return null;
            }
            NativeMapped nativeMappedDefaultValue = NativeMappedConverter.getInstance(cls).defaultValue();
            setFieldValue(field, nativeMappedDefaultValue);
            return nativeMappedDefaultValue;
        }
        try {
            Structure structureNewInstance = newInstance((Class<Structure>) cls, PLACEHOLDER_MEMORY);
            setFieldValue(field, structureNewInstance);
            return structureNewInstance;
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("Can't determine size of nested structure", e3);
        }
    }

    private void initializeFields() {
        for (Field field : getFieldList()) {
            try {
                if (field.get(this) == null) {
                    initializeField(field, field.getType());
                }
            } catch (Exception e3) {
                throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e3);
            }
        }
    }

    private void initializeTypeMapper(TypeMapper typeMapper) {
        if (typeMapper == null) {
            typeMapper = Native.getTypeMapper(getClass());
        }
        this.typeMapper = typeMapper;
        layoutChanged();
    }

    private void layoutChanged() {
        if (this.size != -1) {
            this.size = -1;
            if (this.memory instanceof AutoAllocated) {
                this.memory = null;
            }
            ensureAllocated();
        }
    }

    private static <T extends Structure> T newInstance(Class<T> cls, long j3) {
        try {
            T t2 = (T) newInstance(cls, j3 == 0 ? PLACEHOLDER_MEMORY : new Pointer(j3));
            if (j3 != 0) {
                t2.conditionalAutoRead();
            }
            return t2;
        } catch (Throwable th) {
            LOG.log(Level.WARNING, "JNA: Error creating structure", th);
            return null;
        }
    }

    static Map<Pointer, Structure> reading() {
        return reads.get();
    }

    private static <T extends Comparable<T>> List<T> sort(Collection<? extends T> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void structureArrayCheck(Structure[] structureArr) {
        if (ByReference[].class.isAssignableFrom(structureArr.getClass())) {
            return;
        }
        Pointer pointer = structureArr[0].getPointer();
        int size = structureArr[0].size();
        for (int i3 = 1; i3 < structureArr.length; i3++) {
            if (structureArr[i3].getPointer().peer != pointer.peer + ((long) (size * i3))) {
                throw new IllegalArgumentException("Structure array elements must use contiguous memory (bad backing address at Structure array index " + i3 + ")");
            }
        }
    }

    static <T extends Structure> T updateStructureByReference(Class<T> cls, T t2, Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        if (t2 != null && pointer.equals(t2.getPointer())) {
            t2.autoRead();
            return t2;
        }
        T t3 = (T) reading().get(pointer);
        if (t3 != null && cls.equals(t3.getClass())) {
            t3.autoRead();
            return t3;
        }
        T t4 = (T) newInstance(cls, pointer);
        t4.conditionalAutoRead();
        return t4;
    }

    static void validate(Class<? extends Structure> cls) {
        try {
            cls.getConstructor(null);
        } catch (NoSuchMethodException | SecurityException unused) {
            throw new IllegalArgumentException("No suitable constructor found for class: " + cls.getName());
        }
    }

    private void validateFields() {
        ReentrantReadWriteLock reentrantReadWriteLock = validationLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            Map<Class<?>, Boolean> map = validationMap;
            if (map.containsKey(getClass())) {
                reentrantReadWriteLock.readLock().unlock();
                return;
            }
            reentrantReadWriteLock.readLock().unlock();
            reentrantReadWriteLock.writeLock().lock();
            try {
                map.computeIfAbsent(getClass(), new java.util.function.Function() { // from class: com.sun.jna.b
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Structure.c(this.f93450a, (Class) obj);
                    }
                });
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                validationLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            validationLock.readLock().unlock();
            throw th2;
        }
    }

    protected void allocateMemory() {
        allocateMemory(false);
    }

    protected Memory autoAllocate(int i3) {
        return new AutoAllocated(i3);
    }

    protected void cacheTypeInfo(Pointer pointer) {
        this.typeInfo = pointer.peer;
    }

    protected int calculateSize(boolean z2) {
        return calculateSize(z2, false);
    }

    public void clear() {
        ensureAllocated();
        this.nativeStrings.clear();
        this.memory.clear(size());
    }

    void conditionalAutoRead() {
        if (this.readCalled) {
            return;
        }
        autoRead();
    }

    public boolean dataEquals(Structure structure) {
        return dataEquals(structure, false);
    }

    protected void ensureAllocated() {
        ensureAllocated(false);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Structure) && obj.getClass() == getClass() && ((Structure) obj).getPointer().equals(getPointer());
    }

    protected int fieldOffset(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            return structField.offset;
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    Map<String, StructField> fields() {
        return this.structFields;
    }

    public boolean getAutoRead() {
        return this.autoRead;
    }

    public boolean getAutoWrite() {
        return this.autoWrite;
    }

    protected List<Field> getFieldList() {
        final Class<?> cls = getClass();
        ReentrantReadWriteLock reentrantReadWriteLock = fieldListLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            Map<Class<?>, List<Field>> map = fieldList;
            List<Field> list = map.get(cls);
            if (list != null) {
                reentrantReadWriteLock.readLock().unlock();
                return list;
            }
            reentrantReadWriteLock.readLock().unlock();
            reentrantReadWriteLock.writeLock().lock();
            try {
                List<Field> listComputeIfAbsent = map.computeIfAbsent(cls, new java.util.function.Function() { // from class: com.sun.jna.c
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Structure.a(cls, (Class) obj);
                    }
                });
                reentrantReadWriteLock.writeLock().unlock();
                return listComputeIfAbsent;
            } catch (Throwable th) {
                fieldListLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            fieldListLock.readLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getFieldOrder() {
        LinkedList linkedList = new LinkedList();
        for (Class<?> superclass = getClass(); superclass != Structure.class; superclass = superclass.getSuperclass()) {
            FieldOrder fieldOrder2 = (FieldOrder) superclass.getAnnotation(FieldOrder.class);
            if (fieldOrder2 != null) {
                linkedList.addAll(0, Arrays.asList(fieldOrder2.value()));
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    FFIType getFieldTypeInfo(StructField structField) {
        ToNativeConverter toNativeConverter;
        Class<?> clsNativeType = structField.type;
        Object fieldValue = getFieldValue(structField.field);
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(clsNativeType)) != null) {
            clsNativeType = toNativeConverter.nativeType();
            fieldValue = toNativeConverter.toNative(fieldValue, new ToNativeContext());
        }
        return FFIType.get(fieldValue, clsNativeType);
    }

    Object getFieldValue(Field field) {
        try {
            return field.get(this);
        } catch (Exception e3) {
            throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e3);
        }
    }

    protected List<Field> getFields(boolean z2) {
        List<Field> fieldList2 = getFieldList();
        HashSet hashSet = new HashSet();
        Iterator<Field> it = fieldList2.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        List<String> listFieldOrder = fieldOrder();
        if (listFieldOrder.size() == fieldList2.size() || fieldList2.size() <= 1) {
            if (new HashSet(listFieldOrder).equals(hashSet)) {
                sortFields(fieldList2, listFieldOrder);
                return fieldList2;
            }
            throw new Error("Structure.getFieldOrder() on " + getClass() + " returns names (" + sort(listFieldOrder) + ") which do not match declared field names (" + sort(hashSet) + ")");
        }
        if (!z2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Structure.getFieldOrder() on ");
        sb.append(getClass());
        sb.append(listFieldOrder.size() < fieldList2.size() ? " does not provide enough" : " provides too many");
        sb.append(" names [");
        sb.append(listFieldOrder.size());
        sb.append("] (");
        sb.append(sort(listFieldOrder));
        sb.append(") to match declared fields [");
        sb.append(fieldList2.size());
        sb.append("] (");
        sb.append(sort(hashSet));
        sb.append(")");
        throw new Error(sb.toString());
    }

    protected int getNativeAlignment(Class<?> cls, Object obj, boolean z2) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            Class<?> clsNativeType = nativeMappedConverter.nativeType();
            obj = nativeMappedConverter.toNative(obj, new ToNativeContext());
            cls = clsNativeType;
        }
        int nativeSize = Native.getNativeSize(cls, obj);
        if (!cls.isPrimitive() && Long.class != cls && Integer.class != cls && Short.class != cls && Character.class != cls && Byte.class != cls && Boolean.class != cls && Float.class != cls && Double.class != cls) {
            if ((Pointer.class.isAssignableFrom(cls) && !Function.class.isAssignableFrom(cls)) || ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls) || WString.class == cls || String.class == cls)) {
                nativeSize = Native.POINTER_SIZE;
            } else if (Structure.class.isAssignableFrom(cls)) {
                if (ByReference.class.isAssignableFrom(cls)) {
                    nativeSize = Native.POINTER_SIZE;
                } else {
                    if (obj == null) {
                        obj = newInstance(cls, PLACEHOLDER_MEMORY);
                    }
                    nativeSize = ((Structure) obj).getStructAlignment();
                }
            } else {
                if (!cls.isArray()) {
                    throw new IllegalArgumentException("Type " + cls + " has unknown native alignment");
                }
                nativeSize = getNativeAlignment(cls.getComponentType(), null, z2);
            }
        }
        int i3 = this.actualAlignType;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3) {
            return Math.min(8, nativeSize);
        }
        if (i3 == 2) {
            if (!z2 || !Platform.isMac() || !Platform.isPPC()) {
                nativeSize = Math.min(Native.MAX_ALIGNMENT, nativeSize);
            }
            if (!z2 && Platform.isAIX() && (cls == Double.TYPE || cls == Double.class)) {
                return 4;
            }
        }
        return nativeSize;
    }

    protected int getNativeSize(Class<?> cls) {
        return getNativeSize(cls, null);
    }

    public Pointer getPointer() {
        ensureAllocated();
        return this.memory;
    }

    protected String getStringEncoding() {
        return this.encoding;
    }

    protected int getStructAlignment() {
        if (this.size == -1) {
            calculateSize(true);
        }
        return this.structAlignment;
    }

    Pointer getTypeInfo() {
        Pointer pointer = getTypeInfo(this).getPointer();
        cacheTypeInfo(pointer);
        return pointer;
    }

    TypeMapper getTypeMapper() {
        return this.typeMapper;
    }

    public int hashCode() {
        return getPointer() != null ? getPointer().hashCode() : getClass().hashCode();
    }

    public void read() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        this.readCalled = true;
        ensureAllocated();
        if (busy().add(this)) {
            boolean z2 = this instanceof ByReference;
            if (z2) {
                reading().put(getPointer(), this);
            }
            try {
                Iterator<StructField> it = fields().values().iterator();
                while (it.hasNext()) {
                    readField(it.next());
                }
            } finally {
                busy().remove(this);
                if (z2 && reading().get(getPointer()) == this) {
                    reading().remove(getPointer());
                }
            }
        }
    }

    public Object readField(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            return readField(structField);
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    protected void setAlignType(int i3) {
        this.alignType = i3;
        if (i3 == 0 && (i3 = Native.getStructureAlignment(getClass())) == 0) {
            i3 = Platform.isWindows() ? 3 : 2;
        }
        this.actualAlignType = i3;
        layoutChanged();
    }

    public void setAutoRead(boolean z2) {
        this.autoRead = z2;
    }

    public void setAutoSynch(boolean z2) {
        setAutoRead(z2);
        setAutoWrite(z2);
    }

    public void setAutoWrite(boolean z2) {
        this.autoWrite = z2;
    }

    void setFieldValue(Field field, Object obj) {
        setFieldValue(field, obj, false);
    }

    protected void setStringEncoding(String str) {
        this.encoding = str;
    }

    public int size() {
        ensureAllocated();
        return this.size;
    }

    protected void sortFields(List<Field> list, List<String> list2) {
        for (int i3 = 0; i3 < list2.size(); i3++) {
            String str = list2.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                if (str.equals(list.get(i4).getName())) {
                    Collections.swap(list, i3, i4);
                    break;
                }
                i4++;
            }
        }
    }

    public Structure[] toArray(Structure[] structureArr) {
        ensureAllocated();
        Pointer pointer = this.memory;
        if (pointer instanceof AutoAllocated) {
            int length = structureArr.length * size();
            if (((Memory) pointer).size() < length) {
                useMemory(autoAllocate(length));
            }
        }
        structureArr[0] = this;
        int size = size();
        for (int i3 = 1; i3 < structureArr.length; i3++) {
            Structure structureNewInstance = newInstance((Class<Structure>) getClass(), this.memory.share(i3 * size, size));
            structureArr[i3] = structureNewInstance;
            structureNewInstance.conditionalAutoRead();
        }
        if (!(this instanceof ByValue)) {
            this.array = structureArr;
        }
        return structureArr;
    }

    public String toString() {
        return toString(Boolean.getBoolean("jna.dump_memory"));
    }

    protected void useMemory(Pointer pointer) {
        useMemory(pointer, 0);
    }

    public void write() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        ensureAllocated();
        if (this instanceof ByValue) {
            getTypeInfo();
        }
        if (busy().add(this)) {
            try {
                for (StructField structField : fields().values()) {
                    if (!structField.isVolatile) {
                        writeField(structField);
                    }
                }
            } finally {
                busy().remove(this);
            }
        }
    }

    public void writeField(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            writeField(structField);
            return;
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    protected Structure(TypeMapper typeMapper) {
        this(null, 0, typeMapper);
    }

    private int addPadding(int i3, int i4) {
        int i5;
        return (this.actualAlignType == 1 || (i5 = i3 % i4) == 0) ? i3 : i3 + (i4 - i5);
    }

    private void allocateMemory(boolean z2) {
        allocateMemory(calculateSize(true, z2));
    }

    public static List<String> createFieldsOrder(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureAllocated(boolean z2) {
        if (this.memory == null) {
            allocateMemory(z2);
            return;
        }
        if (this.size == -1) {
            int iCalculateSize = calculateSize(true, z2);
            this.size = iCalculateSize;
            Pointer pointer = this.memory;
            if (pointer instanceof AutoAllocated) {
                return;
            }
            try {
                this.memory = pointer.share(0L, iCalculateSize);
            } catch (IndexOutOfBoundsException e3) {
                throw new IllegalArgumentException("Structure exceeds provided memory bounds", e3);
            }
        }
    }

    private void setFieldValue(Field field, Object obj, boolean z2) {
        try {
            field.set(this, obj);
        } catch (IllegalAccessException e3) {
            if (!Modifier.isFinal(field.getModifiers())) {
                throw new Error("Unexpectedly unable to write to field '" + field.getName() + "' within " + getClass(), e3);
            }
            if (!z2) {
                throw new UnsupportedOperationException("Attempt to write to read-only field '" + field.getName() + "' within " + getClass(), e3);
            }
            throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + field.getName() + "' within " + getClass() + ")", e3);
        }
    }

    private void validateField(String str, Class<?> cls) {
        ToNativeConverter toNativeConverter;
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
            validateField(str, toNativeConverter.nativeType());
            return;
        }
        if (cls.isArray()) {
            validateField(str, cls.getComponentType());
            return;
        }
        try {
            getNativeSize(cls);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("Invalid Structure field in " + getClass() + KqqtdetwHMIO.LKghK + str + "' (" + cls + "): " + e3.getMessage(), e3);
        }
    }

    int calculateSize(boolean z2, boolean z3) {
        Class<?> cls = getClass();
        ReentrantReadWriteLock reentrantReadWriteLock = layoutInfoLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            Map<Class<?>, LayoutInfo> map = layoutInfo;
            LayoutInfo layoutInfoDeriveLayout = map.get(cls);
            reentrantReadWriteLock.readLock().unlock();
            if (layoutInfoDeriveLayout == null || this.alignType != layoutInfoDeriveLayout.alignType || this.typeMapper != layoutInfoDeriveLayout.typeMapper) {
                layoutInfoDeriveLayout = deriveLayout(z2, z3);
            }
            if (layoutInfoDeriveLayout == null) {
                return -1;
            }
            this.structAlignment = layoutInfoDeriveLayout.alignment;
            this.structFields = layoutInfoDeriveLayout.fields;
            if (!layoutInfoDeriveLayout.variable) {
                reentrantReadWriteLock.readLock().lock();
                try {
                    if (!map.containsKey(cls) || this.alignType != 0 || this.typeMapper != null) {
                        reentrantReadWriteLock.readLock().unlock();
                        reentrantReadWriteLock.writeLock().lock();
                        map.put(cls, layoutInfoDeriveLayout);
                        reentrantReadWriteLock.readLock().lock();
                        reentrantReadWriteLock.writeLock().unlock();
                    }
                    reentrantReadWriteLock.readLock().unlock();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return layoutInfoDeriveLayout.size;
        } finally {
            layoutInfoLock.readLock().unlock();
        }
    }

    public boolean dataEquals(Structure structure, boolean z2) {
        if (z2) {
            structure.getPointer().clear(structure.size());
            structure.write();
            getPointer().clear(size());
            write();
        }
        byte[] byteArray = structure.getPointer().getByteArray(0L, structure.size());
        byte[] byteArray2 = getPointer().getByteArray(0L, size());
        if (byteArray.length != byteArray2.length) {
            return false;
        }
        for (int i3 = 0; i3 < byteArray.length; i3++) {
            if (byteArray[i3] != byteArray2[i3]) {
                return false;
            }
        }
        return true;
    }

    protected int getNativeSize(Class<?> cls, Object obj) {
        return Native.getNativeSize(cls, obj);
    }

    public String toString(boolean z2) {
        return toString(0, true, z2);
    }

    protected void useMemory(Pointer pointer, int i3) {
        useMemory(pointer, i3, false);
    }

    protected Structure(int i3) {
        this((Pointer) null, i3);
    }

    static FFIType getTypeInfo(Object obj) {
        return FFIType.get(obj);
    }

    static int size(Class<? extends Structure> cls) {
        return size(cls, null);
    }

    private String toString(int i3, boolean z2, boolean z3) {
        String str;
        String str2;
        String str3;
        ensureAllocated();
        String strLineSeparator = System.lineSeparator();
        String str4 = format(getClass()) + "(" + getPointer() + ")";
        if (!(getPointer() instanceof Memory)) {
            str4 = str4 + " (" + size() + " bytes)";
        }
        String str5 = "";
        for (int i4 = 0; i4 < i3; i4++) {
            str5 = str5 + "  ";
        }
        if (!z2) {
            str = "...}";
        } else {
            Iterator<StructField> it = fields().values().iterator();
            String str6 = strLineSeparator;
            while (it.hasNext()) {
                StructField next = it.next();
                Object fieldValue = getFieldValue(next.field);
                String str7 = format(next.type);
                String str8 = str6 + str5;
                if (!next.type.isArray() || fieldValue == null) {
                    str2 = "";
                } else {
                    str7 = format(next.type.getComponentType());
                    str2 = "[" + Array.getLength(fieldValue) + "]";
                }
                String str9 = str8 + String.format("  %s %s%s@0x%X", str7, next.name, str2, Integer.valueOf(next.offset));
                if (fieldValue instanceof Structure) {
                    fieldValue = ((Structure) fieldValue).toString(i3 + 1, !(fieldValue instanceof ByReference), z3);
                }
                String str10 = str9 + "=";
                if (fieldValue instanceof Long) {
                    str3 = str10 + String.format("0x%08X", (Long) fieldValue);
                } else if (fieldValue instanceof Integer) {
                    str3 = str10 + String.format("0x%04X", (Integer) fieldValue);
                } else if (fieldValue instanceof Short) {
                    str3 = str10 + String.format("0x%02X", (Short) fieldValue);
                } else if (fieldValue instanceof Byte) {
                    str3 = str10 + String.format("0x%01X", (Byte) fieldValue);
                } else {
                    str3 = str10 + String.valueOf(fieldValue).trim();
                }
                String str11 = str3 + strLineSeparator;
                if (!it.hasNext()) {
                    str11 = str11 + str5 + "}";
                }
                str6 = str11;
            }
            str = str6;
        }
        if (i3 == 0 && z3) {
            String str12 = str + strLineSeparator + "memory dump" + strLineSeparator;
            byte[] byteArray = getPointer().getByteArray(0L, size());
            for (int i5 = 0; i5 < byteArray.length; i5++) {
                int i6 = i5 % 4;
                if (i6 == 0) {
                    str12 = str12 + "[";
                }
                byte b3 = byteArray[i5];
                if (b3 >= 0 && b3 < 16) {
                    str12 = str12 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                str12 = str12 + Integer.toHexString(byteArray[i5] & 255);
                if (i6 == 3 && i5 < byteArray.length - 1) {
                    str12 = str12 + "]" + strLineSeparator;
                }
            }
            str = str12 + "]";
        }
        return str4 + " {" + str;
    }

    protected void allocateMemory(int i3) {
        if (i3 == -1) {
            i3 = calculateSize(false);
        } else if (i3 <= 0) {
            throw new IllegalArgumentException(sKeKFMqmvNzY.fEiuWW + i3);
        }
        if (i3 != -1) {
            Pointer pointer = this.memory;
            if (pointer == null || (pointer instanceof AutoAllocated)) {
                this.memory = autoAllocate(i3);
            }
            this.size = i3;
        }
    }

    void useMemory(Pointer pointer, int i3, boolean z2) {
        try {
            this.nativeStrings.clear();
            if ((this instanceof ByValue) && !z2) {
                int size = size();
                byte[] bArr = new byte[size];
                pointer.read(0L, bArr, 0, size);
                this.memory.write(0L, bArr, 0, size);
            } else {
                if (this.size == -1) {
                    this.size = calculateSize(false);
                }
                int i4 = this.size;
                if (i4 != -1) {
                    this.memory = pointer.share(i3, i4);
                } else {
                    this.memory = pointer.share(i3);
                }
            }
            this.array = null;
            this.readCalled = false;
        } catch (IndexOutOfBoundsException e3) {
            throw new IllegalArgumentException("Structure exceeds provided memory bounds", e3);
        }
    }

    protected Structure(int i3, TypeMapper typeMapper) {
        this(null, i3, typeMapper);
    }

    public static <T extends Structure> T newInstance(Class<T> cls, Pointer pointer) throws IllegalArgumentException {
        try {
            Constructor pointerConstructor = getPointerConstructor(cls);
            if (pointerConstructor != null) {
                return (T) pointerConstructor.newInstance(pointer);
            }
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Instantiation of " + cls + " (Pointer) not allowed, is it public?", e3);
        } catch (InstantiationException e4) {
            throw new IllegalArgumentException("Can't instantiate " + cls, e4);
        } catch (SecurityException unused) {
        } catch (InvocationTargetException e5) {
            throw new IllegalArgumentException("Exception thrown while instantiating an instance of " + cls, e5);
        }
        T t2 = (T) newInstance(cls);
        if (pointer != PLACEHOLDER_MEMORY) {
            t2.useMemory(pointer);
        }
        return t2;
    }

    static <T extends Structure> int size(Class<T> cls, T t2) {
        ReentrantReadWriteLock reentrantReadWriteLock = layoutInfoLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            LayoutInfo layoutInfo2 = layoutInfo.get(cls);
            reentrantReadWriteLock.readLock().unlock();
            int i3 = (layoutInfo2 == null || layoutInfo2.variable) ? -1 : layoutInfo2.size;
            if (i3 != -1) {
                return i3;
            }
            if (t2 == null) {
                t2 = (T) newInstance(cls, PLACEHOLDER_MEMORY);
            }
            return t2.size();
        } catch (Throwable th) {
            layoutInfoLock.readLock().unlock();
            throw th;
        }
    }

    protected Structure(Pointer pointer) {
        this(pointer, 0);
    }

    protected Object readField(StructField structField) {
        int i3 = structField.offset;
        Class<?> clsNativeType = structField.type;
        FromNativeConverter fromNativeConverter = structField.readConverter;
        if (fromNativeConverter != null) {
            clsNativeType = fromNativeConverter.nativeType();
        }
        Object value = null;
        Object fieldValue = (Structure.class.isAssignableFrom(clsNativeType) || Callback.class.isAssignableFrom(clsNativeType) || (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clsNativeType)) || Pointer.class.isAssignableFrom(clsNativeType) || NativeMapped.class.isAssignableFrom(clsNativeType) || clsNativeType.isArray()) ? getFieldValue(structField.field) : null;
        if (clsNativeType == String.class) {
            Pointer pointer = this.memory.getPointer(i3);
            if (pointer != null) {
                value = pointer.getString(0L, this.encoding);
            }
        } else {
            value = this.memory.getValue(i3, clsNativeType, fieldValue);
        }
        if (fromNativeConverter != null) {
            Object objFromNative = fromNativeConverter.fromNative(value, structField.context);
            if (fieldValue == null || !fieldValue.equals(objFromNative)) {
                fieldValue = objFromNative;
            }
        } else {
            fieldValue = value;
        }
        if (clsNativeType.equals(String.class) || clsNativeType.equals(WString.class)) {
            if (fieldValue != null) {
                NativeStringTracking nativeStringTracking = new NativeStringTracking(fieldValue);
                NativeStringTracking nativeStringTrackingPut = this.nativeStrings.put(structField.name, nativeStringTracking);
                if (nativeStringTrackingPut != null) {
                    nativeStringTracking.peer = nativeStringTrackingPut.peer;
                }
            } else {
                this.nativeStrings.remove(structField.name);
            }
        }
        setFieldValue(structField.field, fieldValue, true);
        return fieldValue;
    }

    public void writeField(String str, Object obj) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            setFieldValue(structField.field, obj);
            writeField(structField, obj);
        } else {
            throw new IllegalArgumentException("No such field: " + str);
        }
    }

    protected Structure(Pointer pointer, int i3) {
        this(pointer, i3, null);
    }

    public static List<String> createFieldsOrder(String str) {
        return Collections.unmodifiableList(Collections.singletonList(str));
    }

    protected Structure(Pointer pointer, int i3, TypeMapper typeMapper) {
        this.size = -1;
        this.nativeStrings = new HashMap(8);
        this.autoRead = true;
        this.autoWrite = true;
        setAlignType(i3);
        setStringEncoding(Native.getStringEncoding(getClass()));
        initializeTypeMapper(typeMapper);
        validateFields();
        if (pointer != null) {
            useMemory(pointer, 0, true);
        } else {
            allocateMemory(-1);
        }
        initializeFields();
    }

    public static List<String> createFieldsOrder(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public void autoRead() {
        if (!getAutoRead()) {
            return;
        }
        read();
        if (this.array == null) {
            return;
        }
        int i3 = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i3 >= structureArr.length) {
                return;
            }
            structureArr[i3].autoRead();
            i3++;
        }
    }

    public void autoWrite() {
        if (!getAutoWrite()) {
            return;
        }
        write();
        if (this.array == null) {
            return;
        }
        int i3 = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i3 >= structureArr.length) {
                return;
            }
            structureArr[i3].autoWrite();
            i3++;
        }
    }

    protected void writeField(StructField structField) {
        if (structField.isReadOnly) {
            return;
        }
        writeField(structField, getFieldValue(structField.field));
    }

    private void writeField(StructField structField, Object obj) {
        NativeString nativeString;
        String str;
        int i3 = structField.offset;
        Class<?> clsNativeType = structField.type;
        ToNativeConverter toNativeConverter = structField.writeConverter;
        if (toNativeConverter != null) {
            obj = toNativeConverter.toNative(obj, new StructureWriteContext(this, structField.field));
            clsNativeType = toNativeConverter.nativeType();
        }
        if (String.class == clsNativeType || WString.class == clsNativeType) {
            if (obj != null) {
                NativeStringTracking nativeStringTracking = new NativeStringTracking(obj);
                NativeStringTracking nativeStringTrackingPut = this.nativeStrings.put(structField.name, nativeStringTracking);
                if (nativeStringTrackingPut == null || !obj.equals(nativeStringTrackingPut.value)) {
                    if (clsNativeType == WString.class) {
                        nativeString = new NativeString(obj.toString(), true);
                    } else {
                        nativeString = new NativeString(obj.toString(), this.encoding);
                    }
                    nativeStringTracking.peer = nativeString;
                    obj = nativeString.getPointer();
                } else {
                    nativeStringTracking.peer = nativeStringTrackingPut.peer;
                    return;
                }
            } else {
                this.nativeStrings.remove(structField.name);
            }
        }
        try {
            this.memory.setValue(i3, obj, clsNativeType);
        } catch (IllegalArgumentException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Structure field \"");
            sb.append(structField.name);
            sb.append("\" was declared as ");
            sb.append(structField.type);
            if (structField.type == clsNativeType) {
                str = "";
            } else {
                str = " (native type " + clsNativeType + ")";
            }
            sb.append(str);
            sb.append(", which is not supported within a Structure");
            throw new IllegalArgumentException(sb.toString(), e3);
        }
    }

    public Structure[] toArray(int i3) {
        return toArray((Structure[]) Array.newInstance(getClass(), i3));
    }

    public static <T extends Structure> T newInstance(Class<T> cls) throws IllegalArgumentException {
        T t2 = (T) Klass.newInstance(cls);
        if (t2 instanceof ByValue) {
            t2.allocateMemory();
        }
        return t2;
    }
}
