package cz.mobilesoft.coreblock.scene.quickblock.tile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.lifecycle.Lifecycle;
import com.github.appintro.AppIntroBase;
import cz.mobilesoft.coreblock.base.activity.BaseAppIntroActivity;
import cz.mobilesoft.coreblock.scene.quickblock.tile.WhatsNewFragment;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WhatsNewActivity extends BaseAppIntroActivity implements WhatsNewFragment.WhatsNewFragmentListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f114234i = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f114235a = new ArrayList();

        public static /* synthetic */ Builder c(Builder builder, int i3, int i4, int i5, Integer num, int i6, Object obj) {
            if ((i6 & 8) != 0) {
                num = null;
            }
            return builder.a(i3, i4, i5, num);
        }

        public final Builder a(int i3, int i4, int i5, Integer num) {
            return b(new WhatsNewFragment.SlideDTO(i3, i4, i5, num));
        }

        public final Builder b(WhatsNewFragment.SlideDTO slide) {
            Intrinsics.checkNotNullParameter(slide, "slide");
            this.f114235a.add(slide);
            return this;
        }

        public final Intent d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WhatsNewActivity.class);
            intent.putExtra("ITEMS", this.f114235a);
            return intent;
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.quickblock.tile.WhatsNewFragment.WhatsNewFragmentListener
    public void f(WhatsNewFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Y().setVisibility(fragment.isPolicyRespected() && this.f114234i.indexOf(fragment) != CollectionsKt.getLastIndex(this.f114234i) ? 0 : 8);
    }

    @Override // cz.mobilesoft.coreblock.scene.quickblock.tile.WhatsNewFragment.WhatsNewFragmentListener
    public void h() {
        AppIntroBase.goToNextSlide$default(this, false, 1, null);
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAppIntroActivity, com.github.appintro.AppIntro2, com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.b(this, null, null, 3, null);
        Serializable serializableExtra = getIntent().getSerializableExtra("ITEMS");
        ArrayList arrayList = serializableExtra instanceof ArrayList ? (ArrayList) serializableExtra : null;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                WhatsNewFragment whatsNewFragmentA = WhatsNewFragment.f114236c.a((WhatsNewFragment.SlideDTO) obj);
                addSlide(whatsNewFragmentA);
                this.f114234i.add(whatsNewFragmentA);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f114234i.clear();
    }

    @Override // com.github.appintro.AppIntroBase
    protected void onPageSelected(int i3) {
        super.onPageSelected(i3);
        WhatsNewFragment whatsNewFragment = (WhatsNewFragment) this.f114234i.get(i3);
        AnswersHelper.f128199a.l4(i3);
        if (whatsNewFragment.getLifecycle().getCurrentState() == Lifecycle.State.f39951f) {
            f(whatsNewFragment);
        }
    }
}
