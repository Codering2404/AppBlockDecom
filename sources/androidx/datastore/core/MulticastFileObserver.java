package androidx.datastore.core;

import android.os.FileObserver;
import androidx.datastore.core.MulticastFileObserver;
import coil.target.Yb.oUcQRqOVfOC;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class MulticastFileObserver extends FileObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f35778c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f35779d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f35780e = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f35782b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DisposableHandle d(File file, final Function1 function1) {
            final String key = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.f35779d) {
                try {
                    Map mapC = MulticastFileObserver.f35778c.c();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Object multicastFileObserver = mapC.get(key);
                    if (multicastFileObserver == null) {
                        multicastFileObserver = new MulticastFileObserver(key, null);
                        mapC.put(key, multicastFileObserver);
                    }
                    MulticastFileObserver multicastFileObserver2 = (MulticastFileObserver) multicastFileObserver;
                    multicastFileObserver2.f35782b.add(function1);
                    if (multicastFileObserver2.f35782b.size() == 1) {
                        multicastFileObserver2.startWatching();
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new DisposableHandle() { // from class: androidx.datastore.core.a
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    MulticastFileObserver.Companion.f(key, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(String str, Function1 observer) {
            Intrinsics.checkNotNullParameter(observer, "$observer");
            synchronized (MulticastFileObserver.f35779d) {
                try {
                    Companion companion = MulticastFileObserver.f35778c;
                    MulticastFileObserver multicastFileObserver = (MulticastFileObserver) companion.c().get(str);
                    if (multicastFileObserver != null) {
                        multicastFileObserver.f35782b.remove(observer);
                        if (multicastFileObserver.f35782b.isEmpty()) {
                            companion.c().remove(str);
                            multicastFileObserver.stopWatching();
                        }
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Map c() {
            return MulticastFileObserver.f35780e;
        }

        private Companion() {
        }

        public final Flow e(File file) {
            Intrinsics.checkNotNullParameter(file, oUcQRqOVfOC.IIuFzd);
            return FlowKt.j(new MulticastFileObserver$Companion$observe$1(file, null));
        }
    }

    public /* synthetic */ MulticastFileObserver(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // android.os.FileObserver
    public void onEvent(int i3, String str) {
        Iterator it = this.f35782b.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(str);
        }
    }

    private MulticastFileObserver(String str) {
        super(str, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        this.f35781a = str;
        this.f35782b = new CopyOnWriteArrayList();
    }
}
