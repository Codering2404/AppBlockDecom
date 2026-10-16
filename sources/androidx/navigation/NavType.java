package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class NavType<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f48956c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final NavType f48957d = new IntNavType();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NavType f48958e = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$ReferenceType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "reference";
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            m(bundle, str, ((Number) obj).intValue());
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return Integer.valueOf(SavedStateReader.s(SavedStateReader.a(bundle), key));
        }

        @Override // androidx.navigation.NavType
        public Integer l(String value) {
            int i3;
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt.U(value, "0x", false, 2, null)) {
                String strSubstring = value.substring(2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                i3 = Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
            } else {
                i3 = Integer.parseInt(value);
            }
            return Integer.valueOf(i3);
        }

        public void m(Bundle bundle, String key, int i3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            SavedStateWriter.q(SavedStateWriter.a(bundle), key, i3);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NavType f48959f = new IntArrayNavType();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final NavType f48960g = new IntListNavType();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final NavType f48961h = new LongNavType();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final NavType f48962i = new LongArrayNavType();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final NavType f48963j = new LongListNavType();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final NavType f48964k = new FloatNavType();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final NavType f48965l = new FloatArrayNavType();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final NavType f48966m = new FloatListNavType();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final NavType f48967n = new BoolNavType();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final NavType f48968o = new BoolArrayNavType();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final NavType f48969p = new BoolListNavType();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final NavType f48970q = new StringNavType();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final NavType f48971r = new StringArrayNavType();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final NavType f48972s = new StringListNavType();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f48973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f48974b = "nav_type";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public NavType a(String str, String str2) {
            String strSubstring;
            NavType navTypeA = NavTypeKt.a(str);
            if (navTypeA != null) {
                return navTypeA;
            }
            NavType navType = NavType.f48958e;
            if (Intrinsics.areEqual(navType.b(), str)) {
                return navType;
            }
            if (str == null || str.length() == 0) {
                return NavType.f48970q;
            }
            try {
                if (!StringsKt.U(str, ".", false, 2, null) || str2 == null) {
                    strSubstring = str;
                } else {
                    strSubstring = str2 + str;
                }
                boolean zE = StringsKt.E(str, "[]", false, 2, null);
                if (zE) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                Class<?> cls = Class.forName(strSubstring);
                Intrinsics.checkNotNull(cls);
                NavType navTypeD = d(cls, zE);
                if (navTypeD != null) {
                    return navTypeD;
                }
                throw new IllegalArgumentException((strSubstring + " is not Serializable or Parcelable.").toString());
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(e3);
            }
        }

        public final NavType b(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return NavTypeKt.b(value);
        }

        public final NavType c(Object obj) {
            NavType navTypeC = NavTypeKt.c(obj);
            if (navTypeC != null) {
                return navTypeC;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                NavType navType = NavType.f48971r;
                Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType;
            }
            Intrinsics.checkNotNull(obj);
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    return new ParcelableArrayType(componentType2);
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    return new SerializableArrayType(componentType4);
                }
            }
            if (obj instanceof Parcelable) {
                return new ParcelableType(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new EnumType(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new SerializableType(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }

        public final NavType d(Class clazz, boolean z2) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            if (Parcelable.class.isAssignableFrom(clazz)) {
                return z2 ? new ParcelableArrayType(clazz) : new ParcelableType(clazz);
            }
            if (Enum.class.isAssignableFrom(clazz) && !z2) {
                return new EnumType(clazz);
            }
            if (Serializable.class.isAssignableFrom(clazz)) {
                return z2 ? new SerializableArrayType(clazz) : new SerializableType(clazz);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final Class f48975u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumType(Class type) {
            super(false, type);
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.isEnum()) {
                this.f48975u = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public String b() {
            String name = this.f48975u.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        @Override // androidx.navigation.NavType.SerializableType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Enum l(String value) {
            Object obj;
            Intrinsics.checkNotNullParameter(value, "value");
            Object[] enumConstants = this.f48975u.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "getEnumConstants(...)");
            int length = enumConstants.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    obj = null;
                    break;
                }
                obj = enumConstants[i3];
                if (StringsKt.F(((Enum) obj).name(), value, true)) {
                    break;
                }
                i3++;
            }
            Enum r3 = (Enum) obj;
            if (r3 != null) {
                return r3;
            }
            throw new IllegalArgumentException("Enum value " + value + " not found for type " + this.f48975u.getName() + '.');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class f48976t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Parcelable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Parcelable.").toString());
            }
            try {
                Class<?> cls = Class.forName("[L" + type.getName() + ';');
                Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                this.f48976t = cls;
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // androidx.navigation.NavType
        public String b() {
            String name = this.f48976t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual(ParcelableArrayType.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.f48976t, ((ParcelableArrayType) obj).f48976t);
        }

        public int hashCode() {
            return this.f48976t.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Parcelable[] a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return (Parcelable[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public Parcelable[] l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Parcelable[] parcelableArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            this.f48976t.cast(parcelableArr);
            bundle.putParcelableArray(key, parcelableArr);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean j(Parcelable[] parcelableArr, Parcelable[] parcelableArr2) {
            return ArraysKt.contentDeepEquals(parcelableArr, parcelableArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParcelableType<D> extends NavType<D> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class f48977t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            if (Parcelable.class.isAssignableFrom(type) || Serializable.class.isAssignableFrom(type)) {
                this.f48977t = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Parcelable or Serializable.").toString());
        }

        @Override // androidx.navigation.NavType
        public Object a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public String b() {
            String name = this.f48977t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual(ParcelableType.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.f48977t, ((ParcelableType) obj).f48977t);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: f */
        public Object l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void h(Bundle bundle, String key, Object obj) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            this.f48977t.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(key, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) obj);
            }
        }

        public int hashCode() {
            return this.f48977t.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class f48978t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            try {
                Class<?> cls = Class.forName("[L" + type.getName() + ';');
                Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                this.f48978t = cls;
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // androidx.navigation.NavType
        public String b() {
            String name = this.f48978t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual(SerializableArrayType.class, obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.f48978t, ((SerializableArrayType) obj).f48978t);
        }

        public int hashCode() {
            return this.f48978t.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Serializable[] a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return (Serializable[]) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public Serializable[] l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Serializable[] serializableArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            this.f48978t.cast(serializableArr);
            bundle.putSerializable(key, serializableArr);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean j(Serializable[] serializableArr, Serializable[] serializableArr2) {
            return ArraysKt.contentDeepEquals(serializableArr, serializableArr2);
        }
    }

    public NavType(boolean z2) {
        this.f48973a = z2;
    }

    public abstract Object a(Bundle bundle, String str);

    public String b() {
        return this.f48974b;
    }

    public boolean c() {
        return this.f48973a;
    }

    public final Object d(Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return NavTypeKt.d(this, bundle, key, value);
    }

    public final Object e(Bundle bundle, String key, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return NavTypeKt.e(this, bundle, key, str, obj);
    }

    /* JADX INFO: renamed from: f */
    public abstract Object l(String str);

    public Object g(String value, Object obj) {
        Intrinsics.checkNotNullParameter(value, "value");
        return l(value);
    }

    public abstract void h(Bundle bundle, String str, Object obj);

    public String i(Object obj) {
        return String.valueOf(obj);
    }

    public boolean j(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public String toString() {
        return b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class SerializableType<D extends Serializable> extends NavType<D> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class f48979t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Serializable.class.isAssignableFrom(type)) {
                throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
            }
            if (!type.isEnum()) {
                this.f48979t = type;
                return;
            }
            throw new IllegalArgumentException((type + " is an Enum. You should use EnumType instead.").toString());
        }

        @Override // androidx.navigation.NavType
        public String b() {
            String name = this.f48979t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SerializableType) {
                return Intrinsics.areEqual(this.f48979t, ((SerializableType) obj).f48979t);
            }
            return false;
        }

        public int hashCode() {
            return this.f48979t.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Serializable a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return (Serializable) bundle.get(key);
        }

        @Override // androidx.navigation.NavType
        public Serializable l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Serializable value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f48979t.cast(value);
            bundle.putSerializable(key, value);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z2, Class type) {
            super(z2);
            Intrinsics.checkNotNullParameter(type, "type");
            if (Serializable.class.isAssignableFrom(type)) {
                this.f48979t = type;
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }
    }
}
