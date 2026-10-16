package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

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
final class TextFieldTransitionScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextFieldTransitionScope f14967a = new TextFieldTransitionScope();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14980a;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14980a = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    private static final float b(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float c(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long d(State state) {
        return ((Color) state.getValue()).B();
    }

    private static final long e(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final androidx.compose.material.InputPhase r26, final long r27, final long r29, final kotlin.jvm.functions.Function3 r31, final boolean r32, final kotlin.jvm.functions.Function6 r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.a(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }
}
