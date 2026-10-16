package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public final class PagingData<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f50312e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UiReceiver f50313f = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_UI_RECEIVER$1
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HintReceiver f50314g = new HintReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_HINT_RECEIVER$1
        @Override // androidx.paging.HintReceiver
        public void a(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Flow f50315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UiReceiver f50316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HintReceiver f50317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f50318d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0 cachedPageEvent) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(uiReceiver, "uiReceiver");
        Intrinsics.checkNotNullParameter(hintReceiver, "hintReceiver");
        Intrinsics.checkNotNullParameter(cachedPageEvent, "cachedPageEvent");
        this.f50315a = flow;
        this.f50316b = uiReceiver;
        this.f50317c = hintReceiver;
        this.f50318d = cachedPageEvent;
    }

    public final PageEvent.Insert a() {
        return (PageEvent.Insert) this.f50318d.invoke();
    }

    public final Flow b() {
        return this.f50315a;
    }

    public final HintReceiver c() {
        return this.f50317c;
    }

    public final UiReceiver d() {
        return this.f50316b;
    }

    public /* synthetic */ PagingData(Flow flow, UiReceiver uiReceiver, HintReceiver hintReceiver, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(flow, uiReceiver, hintReceiver, (i3 & 8) != 0 ? new Function0() { // from class: androidx.paging.PagingData.1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke() {
                return null;
            }
        } : function0);
    }
}
