package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InputConnectionCompat {

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnCommitContentListener f34606a;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (InputConnectionCompat.e(str, bundle, this.f34606a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api25Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCommitContentListener {
        boolean a(InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle);
    }

    public static /* synthetic */ boolean a(View view, InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle) {
        if ((i3 & 1) != 0) {
            try {
                inputContentInfoCompat.d();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e3) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e3);
                return false;
            }
        }
        return ViewCompat.c0(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.b(), new ClipData.Item(inputContentInfoCompat.a())), 2).d(inputContentInfoCompat.c()).b(bundle).a()) == null;
    }

    private static OnCommitContentListener b(final View view) {
        Preconditions.h(view);
        return new OnCommitContentListener() { // from class: androidx.core.view.inputmethod.a
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public final boolean a(InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle) {
                return InputConnectionCompat.a(view, inputContentInfoCompat, i3, bundle);
            }
        };
    }

    public static InputConnection c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, final OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.d(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.d(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.d(onCommitContentListener, "onCommitContentListener must be non-null");
        return new InputConnectionWrapper(inputConnection, false) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
                if (onCommitContentListener.a(InputContentInfoCompat.f(inputContentInfo), i3, bundle)) {
                    return true;
                }
                return super.commitContent(inputContentInfo, i3, bundle);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean e(String str, Bundle bundle, OnCommitContentListener onCommitContentListener) throws Throwable {
        boolean z2;
        ResultReceiver resultReceiver;
        ?? A = 0;
        A = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z2 = false;
        } else {
            if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                return false;
            }
            z2 = true;
        }
        try {
            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
            try {
                Uri uri = (Uri) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                Uri uri2 = (Uri) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                int i3 = bundle.getInt(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                Bundle bundle2 = (Bundle) bundle.getParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                if (uri != null && clipDescription != null) {
                    A = onCommitContentListener.a(new InputContentInfoCompat(uri, clipDescription, uri2), i3, bundle2);
                }
                if (resultReceiver2 != 0) {
                    resultReceiver2.send(A, null);
                }
                return A;
            } catch (Throwable th) {
                th = th;
                resultReceiver = resultReceiver2;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = null;
        }
    }
}
