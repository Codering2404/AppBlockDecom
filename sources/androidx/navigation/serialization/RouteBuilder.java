package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

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
public final class RouteBuilder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f49456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f49457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f49458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f49459d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ParamType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ParamType f49460a = new ParamType("PATH", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ParamType f49461b = new ParamType("QUERY", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ ParamType[] f49462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f49463d;

        static {
            ParamType[] paramTypeArrA = a();
            f49462c = paramTypeArrA;
            f49463d = EnumEntriesKt.a(paramTypeArrA);
        }

        private ParamType(String str, int i3) {
        }

        private static final /* synthetic */ ParamType[] a() {
            return new ParamType[]{f49460a, f49461b};
        }

        public static ParamType valueOf(String str) {
            return (ParamType) Enum.valueOf(ParamType.class, str);
        }

        public static ParamType[] values() {
            return (ParamType[]) f49462c.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49464a;

        static {
            int[] iArr = new int[ParamType.values().length];
            try {
                iArr[ParamType.f49460a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ParamType.f49461b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f49464a = iArr;
        }
    }

    public RouteBuilder(KSerializer serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f49458c = "";
        this.f49459d = "";
        this.f49456a = serializer;
        this.f49457b = serializer.getDescriptor().i();
    }

    private final void a(String str) {
        this.f49458c += '/' + str;
    }

    private final void b(String str, String str2) {
        this.f49459d += (this.f49459d.length() == 0 ? "?" : "&") + str + '=' + str2;
    }

    private final ParamType f(int i3, NavType navType) {
        return ((navType instanceof CollectionNavType) || this.f49456a.getDescriptor().j(i3)) ? ParamType.f49461b : ParamType.f49460a;
    }

    public final void c(int i3, String name, NavType type, List value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        int i4 = WhenMappings.f49464a[f(i3, type).ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                b(name, (String) it.next());
            }
            return;
        }
        if (value.size() == 1) {
            a((String) CollectionsKt.first(value));
            return;
        }
        throw new IllegalArgumentException(("Expected one value for argument " + name + ", found " + value.size() + "values instead.").toString());
    }

    public final void d(int i3, String name, NavType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        int i4 = WhenMappings.f49464a[f(i3, type).ordinal()];
        if (i4 == 1) {
            a('{' + name + '}');
            return;
        }
        if (i4 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        b(name, '{' + name + '}');
    }

    public final String e() {
        return this.f49457b + this.f49458c + this.f49459d;
    }

    public RouteBuilder(String path, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f49458c = "";
        this.f49459d = "";
        this.f49456a = serializer;
        this.f49457b = path;
    }
}
