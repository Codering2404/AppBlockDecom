package androidx.compose.animation.graphics.vector;

import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimatedImageVector {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f4395d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageVector f4396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f4397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4398c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AnimatedImageVector(ImageVector imageVector, List list) {
        Object obj;
        Animator animatorA;
        this.f4396a = imageVector;
        this.f4397b = list;
        int iD = 0;
        if (list.isEmpty()) {
            obj = null;
        } else {
            obj = list.get(0);
            int iD2 = ((AnimatedVectorTarget) obj).a().d();
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = list.get(i3);
                    int iD3 = ((AnimatedVectorTarget) obj2).a().d();
                    if (iD2 < iD3) {
                        obj = obj2;
                        iD2 = iD3;
                    }
                    if (i3 == lastIndex) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        AnimatedVectorTarget animatedVectorTarget = (AnimatedVectorTarget) obj;
        if (animatedVectorTarget != null && (animatorA = animatedVectorTarget.a()) != null) {
            iD = animatorA.d();
        }
        this.f4398c = iD;
    }

    public final ImageVector a() {
        return this.f4396a;
    }

    public final List b() {
        return this.f4397b;
    }

    public final int c() {
        return this.f4398c;
    }
}
