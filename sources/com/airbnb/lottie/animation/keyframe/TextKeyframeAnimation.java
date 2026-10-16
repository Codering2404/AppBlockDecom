package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public DocumentData i(Keyframe keyframe, float f3) {
        Object obj;
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback == null) {
            return (f3 != 1.0f || (obj = keyframe.f57112c) == null) ? (DocumentData) keyframe.f57111b : (DocumentData) obj;
        }
        float f4 = keyframe.f57116g;
        Float f5 = keyframe.f57117h;
        float fFloatValue = f5 == null ? Float.MAX_VALUE : f5.floatValue();
        Object obj2 = keyframe.f57111b;
        DocumentData documentData = (DocumentData) obj2;
        Object obj3 = keyframe.f57112c;
        return (DocumentData) lottieValueCallback.b(f4, fFloatValue, documentData, obj3 == null ? (DocumentData) obj2 : (DocumentData) obj3, f3, d(), f());
    }

    public void q(final LottieValueCallback lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        super.n(new LottieValueCallback<DocumentData>() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public DocumentData a(LottieFrameInfo lottieFrameInfo2) {
                lottieFrameInfo.h(lottieFrameInfo2.f(), lottieFrameInfo2.a(), ((DocumentData) lottieFrameInfo2.g()).f56680a, ((DocumentData) lottieFrameInfo2.b()).f56680a, lottieFrameInfo2.d(), lottieFrameInfo2.c(), lottieFrameInfo2.e());
                String str = (String) lottieValueCallback.a(lottieFrameInfo);
                DocumentData documentData2 = (DocumentData) (lottieFrameInfo2.c() == 1.0f ? lottieFrameInfo2.b() : lottieFrameInfo2.g());
                documentData.a(str, documentData2.f56681b, documentData2.f56682c, documentData2.f56683d, documentData2.f56684e, documentData2.f56685f, documentData2.f56686g, documentData2.f56687h, documentData2.f56688i, documentData2.f56689j, documentData2.f56690k, documentData2.f56691l, documentData2.f56692m);
                return documentData;
            }
        });
    }
}
