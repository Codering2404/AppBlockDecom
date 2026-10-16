package androidx.activity;

import android.window.BackEvent;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BackEventCompat {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f336e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f340d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Target({ElementType.TYPE_USE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface SwipeEdge {
    }

    public BackEventCompat(float f3, float f4, float f5, int i3) {
        this.f337a = f3;
        this.f338b = f4;
        this.f339c = f5;
        this.f340d = i3;
    }

    public final float a() {
        return this.f339c;
    }

    public final int b() {
        return this.f340d;
    }

    public final float c() {
        return this.f338b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f337a + tDEtWsFLJfe.vxnYvxoetjG + this.f338b + ", progress=" + this.f339c + ", swipeEdge=" + this.f340d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BackEventCompat(BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Api34Impl api34Impl = Api34Impl.f335a;
        this(api34Impl.c(backEvent), api34Impl.d(backEvent), api34Impl.a(backEvent), api34Impl.b(backEvent));
    }
}
