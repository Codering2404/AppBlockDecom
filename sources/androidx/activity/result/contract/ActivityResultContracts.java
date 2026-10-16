package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class ActivityResultContracts {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean parseResult(int i3, Intent intent) {
            return Boolean.valueOf(i3 == -1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f585a;

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f585a).putExtra("android.intent.extra.TITLE", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intentPutExtra;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f586a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List a(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        Uri uri = clipData.getItemAt(i3).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List parseResult(int i3, Intent intent) {
            List listA;
            if (i3 != -1) {
                intent = null;
            }
            return (intent == null || (listA = f586a.a(intent)) == null) ? CollectionsKt.emptyList() : listA;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intentPutExtra;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List parseResult(int i3, Intent intent) {
            List listA;
            if (i3 != -1) {
                intent = null;
            }
            return (intent == null || (listA = GetMultipleContents.f586a.a(intent)) == null) ? CollectionsKt.emptyList() : listA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Void r2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f587b = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f588a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.f589a;
            if (companion.d()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.b(input.d()));
                int iMin = Math.min(this.f588a, input.c());
                if (iMin <= 1 || iMin > MediaStore.getPickImagesMaxLimit()) {
                    throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", iMin);
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
                intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", input.f());
                if (input.e()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
                }
                return intent;
            }
            if (!companion.c(context)) {
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.setType(companion.b(input.d()));
                intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent2.getType() == null) {
                    intent2.setType("*/*");
                    intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent2;
            }
            ResolveInfo resolveInfoA = companion.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo = resolveInfoA.activityInfo;
            Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent3.setType(companion.b(input.d()));
            int iMin2 = Math.min(this.f588a, input.c());
            if (iMin2 <= 1) {
                throw new IllegalArgumentException("Max items must be greater than 1");
            }
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", iMin2);
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", input.f());
            if (input.e()) {
                intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
            }
            return intent3;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List parseResult(int i3, Intent intent) {
            List listA;
            if (i3 != -1) {
                intent = null;
            }
            return (intent == null || (listA = GetMultipleContents.f586a.a(intent)) == null) ? CollectionsKt.emptyList() : listA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f589a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ResolveInfo a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
            }

            public final boolean c(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return a(context) != null;
            }

            public final boolean d() {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 33) {
                    return true;
                }
                return i3 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
            }

            private Companion() {
            }

            public final String b(VisualMediaType input) {
                Intrinsics.checkNotNullParameter(input, "input");
                if (input instanceof ImageOnly) {
                    return "image/*";
                }
                if (input instanceof VideoOnly) {
                    return SbbqvQlxi.ZoGVVLuePfOueZI;
                }
                if (input instanceof SingleMimeType) {
                    return ((SingleMimeType) input).a();
                }
                if (input instanceof ImageAndVideo) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class DefaultTab {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AlbumsTab extends DefaultTab {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final AlbumsTab f590a = new AlbumsTab();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private static final int f591b = 0;

                private AlbumsTab() {
                    super(null);
                }

                @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab
                public int a() {
                    return f591b;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class PhotosTab extends DefaultTab {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final PhotosTab f592a = new PhotosTab();

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private static final int f593b = 1;

                private PhotosTab() {
                    super(null);
                }

                @Override // androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab
                public int a() {
                    return f593b;
                }
            }

            public /* synthetic */ DefaultTab(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract int a();

            private DefaultTab() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ImageAndVideo implements VisualMediaType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ImageAndVideo f594a = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ImageOnly implements VisualMediaType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ImageOnly f595a = new ImageOnly();

            private ImageOnly() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SingleMimeType implements VisualMediaType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f596a;

            public final String a() {
                return this.f596a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class VideoOnly implements VisualMediaType {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final VideoOnly f597a = new VideoOnly();

            private VideoOnly() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public interface VisualMediaType {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Companion companion = f589a;
            if (companion.d()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.b(input.d()));
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
                if (input.e()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
                }
                return intent;
            }
            if (!companion.c(context)) {
                Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent2.setType(companion.b(input.d()));
                if (intent2.getType() == null) {
                    intent2.setType("*/*");
                    intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
                return intent2;
            }
            ResolveInfo resolveInfoA = companion.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo = resolveInfoA.activityInfo;
            Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent3.setType(companion.b(input.d()));
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
            if (input.e()) {
                intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
            }
            return intent3;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Uri parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            return data == null ? (Uri) CollectionsKt.firstOrNull(GetMultipleContents.f586a.a(intent)) : data;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f598a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Intent a(String[] input) {
                Intrinsics.checkNotNullParameter(input, "input");
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return f598a.a(input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (input.length == 0) {
                return new ActivityResultContract.SynchronousResult(MapsKt.emptyMap());
            }
            for (String str : input) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(input.length), 16));
            for (String str2 : input) {
                Pair pairA = TuplesKt.a(str2, Boolean.TRUE);
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            return new ActivityResultContract.SynchronousResult(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                return MapsKt.emptyMap();
            }
            if (intent == null) {
                return MapsKt.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.emptyMap();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i4 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i4 == 0));
            }
            return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(stringArrayExtra), arrayList));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultContract.SynchronousResult getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (ContextCompat.checkSelfPermission(context, input) == 0) {
                return new ActivityResultContract.SynchronousResult(Boolean.TRUE);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean parseResult(int i3, Intent intent) {
            if (intent == null || i3 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean z2 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    if (intArrayExtra[i4] == 0) {
                        z2 = true;
                        break;
                    }
                    i4++;
                }
            }
            return Boolean.valueOf(z2);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return RequestMultiplePermissions.f598a.a(new String[]{input});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f599a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult parseResult(int i3, Intent intent) {
            return new ActivityResult(i3, intent);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Intent input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return input;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f600a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, IntentSenderRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult parseResult(int i3, Intent intent) {
            return new ActivityResult(i3, intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean parseResult(int i3, Intent intent) {
            return Boolean.valueOf(i3 == -1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Void r2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Void r2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Bitmap parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Deprecated
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Bitmap parseResult(int i3, Intent intent) {
            if (i3 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }
}
