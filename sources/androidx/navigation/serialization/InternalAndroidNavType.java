package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class InternalAndroidNavType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InternalAndroidNavType f49415a = new InternalAndroidNavType();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class EnumListType<D extends Enum<?>> extends CollectionNavType<List<? extends D>> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final NavType.EnumType f49416t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumListType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f49416t = new NavType.EnumType(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnumListType) {
                return Intrinsics.areEqual(this.f49416t, ((EnumListType) obj).f49416t);
            }
            return false;
        }

        public int hashCode() {
            return this.f49416t.hashCode();
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public List k() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public List a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof List) {
                return (List) obj;
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public List l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CollectionsKt.listOf(this.f49416t.f(value));
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public List g(String value, List list) {
            List listPlus;
            Intrinsics.checkNotNullParameter(value, "value");
            return (list == null || (listPlus = CollectionsKt.plus((Collection) list, (Iterable) l(value))) == null) ? l(value) : listPlus;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, List list) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            bundle.putSerializable(key, list != null ? new ArrayList(list) : null);
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public List l(List list) {
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Enum) it.next()).toString());
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean j(List list, List list2) {
            return Intrinsics.areEqual(list != null ? new ArrayList(list) : null, list2 != null ? new ArrayList(list2) : null);
        }

        @Override // androidx.navigation.NavType
        public String b() {
            return "List<" + this.f49416t.b() + SbbqvQlxi.nOpmFmhMiTWUQb;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnumNullableType<D extends Enum<?>> extends SerializableNullableType<D> {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final Class f49417u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumNullableType(Class type) {
            super(type);
            Intrinsics.checkNotNullParameter(type, "type");
            if (type.isEnum()) {
                this.f49417u = type;
                return;
            }
            throw new IllegalArgumentException((type + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.serialization.InternalAndroidNavType.SerializableNullableType, androidx.navigation.NavType
        public String b() {
            String name = this.f49417u.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        @Override // androidx.navigation.serialization.InternalAndroidNavType.SerializableNullableType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Enum l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Object obj = null;
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            Object[] enumConstants = this.f49417u.getEnumConstants();
            Intrinsics.checkNotNull(enumConstants);
            int length = enumConstants.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Object obj2 = enumConstants[i3];
                Enum r5 = (Enum) obj2;
                Intrinsics.checkNotNull(r5);
                if (StringsKt.F(r5.name(), value, true)) {
                    obj = obj2;
                    break;
                }
                i3++;
            }
            Enum r12 = (Enum) obj;
            if (r12 != null) {
                return r12;
            }
            throw new IllegalArgumentException("Enum value " + value + " not found for type " + this.f49417u.getName() + '.');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class SerializableNullableType<D extends Serializable> extends NavType<D> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Class f49418t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableNullableType(Class type) {
            super(true);
            Intrinsics.checkNotNullParameter(type, "type");
            this.f49418t = type;
            if (Serializable.class.isAssignableFrom(type)) {
                return;
            }
            throw new IllegalArgumentException((type + " does not implement Serializable.").toString());
        }

        @Override // androidx.navigation.NavType
        public String b() {
            String name = this.f49418t.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SerializableNullableType) {
                return Intrinsics.areEqual(this.f49418t, ((SerializableNullableType) obj).f49418t);
            }
            return false;
        }

        public int hashCode() {
            return this.f49418t.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Serializable a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj = bundle.get(key);
            if (obj instanceof Serializable) {
                return (Serializable) obj;
            }
            return null;
        }

        @Override // androidx.navigation.NavType
        public Serializable l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Serializable serializable) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            bundle.putSerializable(key, (Serializable) this.f49418t.cast(serializable));
        }
    }

    private InternalAndroidNavType() {
    }
}
