package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.memory.MemoryCache;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface MemoryCache {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f55947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f55948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f55949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f55950d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f55951e = true;

        public Builder(Context context) {
            this.f55947a = context;
            this.f55948b = Utils.e(context);
        }

        public final MemoryCache a() {
            StrongMemoryCache emptyStrongMemoryCache;
            WeakMemoryCache realWeakMemoryCache = this.f55951e ? new RealWeakMemoryCache() : new EmptyWeakMemoryCache();
            if (this.f55950d) {
                double d3 = this.f55948b;
                int iC = d3 > 0.0d ? Utils.c(this.f55947a, d3) : this.f55949c;
                emptyStrongMemoryCache = iC > 0 ? new RealStrongMemoryCache(iC, realWeakMemoryCache) : new EmptyStrongMemoryCache(realWeakMemoryCache);
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(realWeakMemoryCache);
            }
            return new RealMemoryCache(emptyStrongMemoryCache, realWeakMemoryCache);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Value {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f55955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f55956b;

        public Value(Bitmap bitmap, Map map) {
            this.f55955a = bitmap;
            this.f55956b = map;
        }

        public final Bitmap a() {
            return this.f55955a;
        }

        public final Map b() {
            return this.f55956b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Intrinsics.areEqual(this.f55955a, value.f55955a) && Intrinsics.areEqual(this.f55956b, value.f55956b);
        }

        public int hashCode() {
            return (this.f55955a.hashCode() * 31) + this.f55956b.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.f55955a + ", extras=" + this.f55956b + ')';
        }
    }

    void a(int i3);

    Value b(Key key);

    void c(Key key, Value value);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f55953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f55954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Companion f55952c = new Companion(null);

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new Parcelable.Creator<Key>() { // from class: coil.memory.MemoryCache$Key$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MemoryCache.Key createFromParcel(Parcel parcel) {
                String string = parcel.readString();
                Intrinsics.checkNotNull(string);
                int i3 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
                for (int i4 = 0; i4 < i3; i4++) {
                    String string2 = parcel.readString();
                    Intrinsics.checkNotNull(string2);
                    String string3 = parcel.readString();
                    Intrinsics.checkNotNull(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new MemoryCache.Key(string, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MemoryCache.Key[] newArray(int i3) {
                return new MemoryCache.Key[i3];
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Key(String str, Map map) {
            this.f55953a = str;
            this.f55954b = map;
        }

        public static /* synthetic */ Key c(Key key, String str, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = key.f55953a;
            }
            if ((i3 & 2) != 0) {
                map = key.f55954b;
            }
            return key.a(str, map);
        }

        public final Key a(String str, Map map) {
            return new Key(str, map);
        }

        public final Map d() {
            return this.f55954b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.f55953a, key.f55953a) && Intrinsics.areEqual(this.f55954b, key.f55954b);
        }

        public int hashCode() {
            return (this.f55953a.hashCode() * 31) + this.f55954b.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.f55953a + ", extras=" + this.f55954b + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f55953a);
            parcel.writeInt(this.f55954b.size());
            for (Map.Entry entry : this.f55954b.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                parcel.writeString(str);
                parcel.writeString(str2);
            }
        }

        public /* synthetic */ Key(String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? MapsKt.emptyMap() : map);
        }
    }
}
