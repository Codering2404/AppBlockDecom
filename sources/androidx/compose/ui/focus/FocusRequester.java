package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class FocusRequester {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25519b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final FocusRequester f25520c = new FocusRequester();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FocusRequester f25521d = new FocusRequester();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FocusRequester f25522e = new FocusRequester();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f25523a = new MutableVector(new FocusRequesterModifierNode[16], 0);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FocusRequesterFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final FocusRequesterFactory f25524a = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FocusRequester a() {
            return FocusRequester.f25521d;
        }

        public final FocusRequester b() {
            return FocusRequester.f25520c;
        }

        public final FocusRequester c() {
            return FocusRequester.f25522e;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ boolean h(FocusRequester focusRequester, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = FocusDirection.f25444b.b();
        }
        return focusRequester.g(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0060, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(kotlin.jvm.functions.Function1 r18) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.d(kotlin.jvm.functions.Function1):boolean");
    }

    public final MutableVector e() {
        return this.f25523a;
    }

    public final /* synthetic */ void f() {
        g(FocusDirection.f25444b.b());
    }

    public final boolean g(final int i3) {
        return d(new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$requestFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.R(i3));
            }
        });
    }
}
