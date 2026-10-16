package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.internal.Utility;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f53777b - itemInfo2.f53777b;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.viewpager.widget.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ItemInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f53776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f53777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f53778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f53779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f53780e;

        ItemInfo() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean n() {
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (pagerAdapter = ViewPager.this.mAdapter) == null) {
                return;
            }
            accessibilityEvent.setItemCount(pagerAdapter.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.i0(ViewPager.class.getName());
            accessibilityNodeInfoCompat.K0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i3, Bundle bundle) {
            if (super.j(view, i3, bundle)) {
                return true;
            }
            if (i3 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem + 1);
                return true;
            }
            if (i3 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem - 1);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnAdapterChangeListener {
        void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i3);

        void onPageScrolled(int i3, float f3, int i4);

        void onPageSelected(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PageTransformer {
        void transformPage(View view, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager.widget.ViewPager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f53789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Parcelable f53790d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ClassLoader f53791f;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f53789c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f53789c);
            parcel.writeParcelable(this.f53790d, i3);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f53789c = parcel.readInt();
            this.f53790d = parcel.readParcelable(classLoader);
            this.f53791f = classLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z2 = layoutParams.f53781a;
            return z2 != layoutParams2.f53781a ? z2 ? 1 : -1 : layoutParams.f53785e - layoutParams2.f53785e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void a(ItemInfo itemInfo, int i3, ItemInfo itemInfo2) {
        int i4;
        int i5;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f3 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i6 = itemInfo2.f53777b;
            int i7 = itemInfo.f53777b;
            if (i6 < i7) {
                float pageWidth = itemInfo2.f53780e + itemInfo2.f53779d + f3;
                int i8 = i6 + 1;
                int i9 = 0;
                while (i8 <= itemInfo.f53777b && i9 < this.mItems.size()) {
                    ItemInfo itemInfo5 = this.mItems.get(i9);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i8 <= itemInfo4.f53777b || i9 >= this.mItems.size() - 1) {
                            break;
                        }
                        i9++;
                        itemInfo5 = this.mItems.get(i9);
                    }
                    while (i8 < itemInfo4.f53777b) {
                        pageWidth += this.mAdapter.getPageWidth(i8) + f3;
                        i8++;
                    }
                    itemInfo4.f53780e = pageWidth;
                    pageWidth += itemInfo4.f53779d + f3;
                    i8++;
                }
            } else if (i6 > i7) {
                int size = this.mItems.size() - 1;
                float pageWidth2 = itemInfo2.f53780e;
                while (true) {
                    i6--;
                    if (i6 < itemInfo.f53777b || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i6 >= itemInfo3.f53777b || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i6 > itemInfo3.f53777b) {
                        pageWidth2 -= this.mAdapter.getPageWidth(i6) + f3;
                        i6--;
                    }
                    pageWidth2 -= itemInfo3.f53779d + f3;
                    itemInfo3.f53780e = pageWidth2;
                }
            }
        }
        int size2 = this.mItems.size();
        float pageWidth3 = itemInfo.f53780e;
        int i10 = itemInfo.f53777b;
        int i11 = i10 - 1;
        this.mFirstOffset = i10 == 0 ? pageWidth3 : -3.4028235E38f;
        int i12 = count - 1;
        this.mLastOffset = i10 == i12 ? (itemInfo.f53779d + pageWidth3) - 1.0f : Float.MAX_VALUE;
        int i13 = i3 - 1;
        while (i13 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i13);
            while (true) {
                i5 = itemInfo7.f53777b;
                if (i11 <= i5) {
                    break;
                }
                pageWidth3 -= this.mAdapter.getPageWidth(i11) + f3;
                i11--;
            }
            pageWidth3 -= itemInfo7.f53779d + f3;
            itemInfo7.f53780e = pageWidth3;
            if (i5 == 0) {
                this.mFirstOffset = pageWidth3;
            }
            i13--;
            i11--;
        }
        float pageWidth4 = itemInfo.f53780e + itemInfo.f53779d + f3;
        int i14 = itemInfo.f53777b + 1;
        int i15 = i3 + 1;
        while (i15 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i15);
            while (true) {
                i4 = itemInfo8.f53777b;
                if (i14 >= i4) {
                    break;
                }
                pageWidth4 += this.mAdapter.getPageWidth(i14) + f3;
                i14++;
            }
            if (i4 == i12) {
                this.mLastOffset = (itemInfo8.f53779d + pageWidth4) - 1.0f;
            }
            itemInfo8.f53780e = pageWidth4;
            pageWidth4 += itemInfo8.f53779d + f3;
            i15++;
            i14++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void b(boolean z2) {
        boolean z3 = this.mScrollState == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (itemInfo.f53778c) {
                itemInfo.f53778c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                ViewCompat.e0(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int c(int i3, float f3, int i4, int i5) {
        if (Math.abs(i5) <= this.mFlingDistance || Math.abs(i4) <= this.mMinimumVelocity) {
            i3 += (int) (f3 + (i3 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i4 <= 0) {
            i3++;
        }
        if (this.mItems.size() <= 0) {
            return i3;
        }
        return Math.max(this.mItems.get(0).f53777b, Math.min(i3, this.mItems.get(r4.size() - 1).f53777b));
    }

    private void d(int i3, float f3, int i4) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i3, f3, i4);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i5);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i3, f3, i4);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i3, f3, i4);
        }
    }

    private void e(int i3) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i3);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i4);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i3);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i3);
        }
    }

    private void f(int i3) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i3);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i4);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrollStateChanged(i3);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrollStateChanged(i3);
        }
    }

    private void g(boolean z2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setLayerType(z2 ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect i(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private ItemInfo j() {
        int i3;
        int clientWidth = getClientWidth();
        float f3 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f4 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        int i4 = 0;
        boolean z2 = true;
        ItemInfo itemInfo = null;
        int i5 = -1;
        float f5 = 0.0f;
        while (i4 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i4);
            if (!z2 && itemInfo2.f53777b != (i3 = i5 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.f53780e = f3 + f5 + f4;
                itemInfo2.f53777b = i3;
                itemInfo2.f53779d = this.mAdapter.getPageWidth(i3);
                i4--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f3 = itemInfo3.f53780e;
            float f6 = itemInfo3.f53779d + f3 + f4;
            if (!z2 && scrollX < f3) {
                break;
            }
            if (scrollX < f6 || i4 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            int i6 = itemInfo3.f53777b;
            float f7 = itemInfo3.f53779d;
            i4++;
            i5 = i6;
            f5 = f7;
            itemInfo = itemInfo3;
            z2 = false;
        }
        return itemInfo;
    }

    private static boolean k(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private boolean l(float f3, float f4) {
        if (f3 >= this.mGutterSize || f4 <= 0.0f) {
            return f3 > ((float) (getWidth() - this.mGutterSize)) && f4 < 0.0f;
        }
        return true;
    }

    private void m(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i3);
            this.mActivePointerId = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean n(int i3) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo itemInfoJ = j();
        int clientWidth = getClientWidth();
        int i4 = this.mPageMargin;
        int i5 = clientWidth + i4;
        float f3 = clientWidth;
        int i6 = itemInfoJ.f53777b;
        float f4 = ((i3 / f3) - itemInfoJ.f53780e) / (itemInfoJ.f53779d + (i4 / f3));
        this.mCalledSuper = false;
        onPageScrolled(i6, f4, (int) (i5 * f4));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean o(float f3) {
        boolean z2;
        boolean z3;
        float f4 = this.mLastMotionX - f3;
        this.mLastMotionX = f3;
        float scrollX = getScrollX() + f4;
        float clientWidth = getClientWidth();
        float f5 = this.mFirstOffset * clientWidth;
        float f6 = this.mLastOffset * clientWidth;
        boolean z4 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f53777b != 0) {
            f5 = itemInfo.f53780e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (itemInfo2.f53777b != this.mAdapter.getCount() - 1) {
            f6 = itemInfo2.f53780e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f5) {
            if (z2) {
                this.mLeftEdge.onPull(Math.abs(f5 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        } else if (scrollX > f6) {
            if (z3) {
                this.mRightEdge.onPull(Math.abs(scrollX - f6) / clientWidth);
                z4 = true;
            }
            scrollX = f6;
        }
        int i3 = (int) scrollX;
        this.mLastMotionX += scrollX - i3;
        scrollTo(i3, getScrollY());
        n(i3);
        return z4;
    }

    private void p(int i3, int i4, int i5, int i6) {
        if (i4 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i4 - getPaddingLeft()) - getPaddingRight()) + i6)) * (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)), getScrollY());
                return;
            }
        }
        ItemInfo itemInfoInfoForPosition = infoForPosition(this.mCurItem);
        int iMin = (int) ((itemInfoInfoForPosition != null ? Math.min(itemInfoInfoForPosition.f53780e, this.mLastOffset) : 0.0f) * ((i3 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            b(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void q() {
        int i3 = 0;
        while (i3 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f53781a) {
                removeViewAt(i3);
                i3--;
            }
            i3++;
        }
    }

    private void r(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean s() {
        this.mActivePointerId = -1;
        h();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.mScrollingCacheEnabled != z2) {
            this.mScrollingCacheEnabled = z2;
        }
    }

    private void t(int i3, boolean z2, int i4, boolean z3) {
        ItemInfo itemInfoInfoForPosition = infoForPosition(i3);
        int clientWidth = itemInfoInfoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfoInfoForPosition.f53780e, this.mLastOffset))) : 0;
        if (z2) {
            smoothScrollTo(clientWidth, 0, i4);
            if (z3) {
                e(i3);
                return;
            }
            return;
        }
        if (z3) {
            e(i3);
        }
        b(false);
        scrollTo(clientWidth, 0);
        n(clientWidth);
    }

    private void u() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.mDrawingOrderedChildren.add(getChildAt(i3));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3, int i4) {
        ItemInfo itemInfoInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.f53777b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i3, i4);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i4 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    ItemInfo addNewItem(int i3, int i4) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f53777b = i3;
        itemInfo.f53776a = this.mAdapter.instantiateItem((ViewGroup) this, i3);
        itemInfo.f53779d = this.mAdapter.getPageWidth(i3);
        if (i4 < 0 || i4 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
            return itemInfo;
        }
        this.mItems.add(i4, itemInfo);
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo itemInfoInfoForChild;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.f53777b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean zK = layoutParams2.f53781a | k(view);
        layoutParams2.f53781a = zK;
        if (!this.mInLayout) {
            super.addView(view, i3, layoutParams);
        } else {
            if (zK) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f53784d = true;
            addViewInLayout(view, i3, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r5) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.mFakeDragBeginTime = jUptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z2, int i3, int i4, int i5) {
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i7 = i4 + scrollX;
                if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && (i6 = i5 + scrollY) >= childAt.getTop() && i6 < childAt.getBottom() && canScroll(childAt, true, i3, i7 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i3);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i3 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i3 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            b(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!n(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d0(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z2 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int iMax = this.mCurItem;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i3);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.f53776a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i3);
                    i3--;
                    if (!z3) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.f53777b, itemInfo.f53776a);
                    int i4 = this.mCurItem;
                    if (i4 == itemInfo.f53777b) {
                        iMax = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = itemInfo.f53777b;
                    if (i5 != itemPosition) {
                        if (i5 == this.mCurItem) {
                            iMax = itemPosition;
                        }
                        itemInfo.f53777b = itemPosition;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.f53781a) {
                    layoutParams.f53783c = 0.0f;
                }
            }
            setCurrentItemInternal(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoInfoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.f53777b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f3) {
        return (float) Math.sin((f3 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                zDraw = this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.mRightEdge.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                zDraw |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (zDraw) {
            ViewCompat.d0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo itemInfoJ = j();
            setCurrentItemInternal(c(itemInfoJ.f53777b, ((scrollX / clientWidth) - itemInfoJ.f53780e) / itemInfoJ.f53779d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        h();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
        }
        if (keyCode == 22) {
            return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return arrowScroll(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return arrowScroll(1);
        }
        return false;
    }

    public void fakeDragBy(float f3) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f3;
        float scrollX = getScrollX() - f3;
        float clientWidth = getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        ItemInfo itemInfo = this.mItems.get(0);
        ItemInfo itemInfo2 = this.mItems.get(r4.size() - 1);
        if (itemInfo.f53777b != 0) {
            f4 = itemInfo.f53780e * clientWidth;
        }
        if (itemInfo2.f53777b != this.mAdapter.getCount() - 1) {
            f5 = itemInfo2.f53780e * clientWidth;
        }
        if (scrollX < f4) {
            scrollX = f4;
        } else if (scrollX > f5) {
            scrollX = f5;
        }
        int i3 = (int) scrollX;
        this.mLastMotionX += scrollX - i3;
        scrollTo(i3, getScrollY());
        n(i3);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        if (this.mDrawingOrder == 2) {
            i4 = (i3 - 1) - i4;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i4).getLayoutParams()).f53786f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    ItemInfo infoForChild(View view) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (this.mAdapter.isViewFromObject(view, itemInfo.f53776a)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i3) {
        for (int i4 = 0; i4 < this.mItems.size(); i4++) {
            ItemInfo itemInfo = this.mItems.get(i4);
            if (itemInfo.f53777b == i3) {
                return itemInfo;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f3);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f3);
        this.mCloseEnough = (int) (2.0f * f3);
        this.mDefaultGutterSize = (int) (f3 * 16.0f);
        ViewCompat.m0(this, new MyAccessibilityDelegate());
        if (ViewCompat.w(this) == 0) {
            ViewCompat.w0(this, 1);
        }
        ViewCompat.C0(this, new OnApplyWindowInsetsListener() { // from class: androidx.viewpager.widget.ViewPager.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Rect f53774a = new Rect();

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat windowInsetsCompatY = ViewCompat.Y(view, windowInsetsCompat);
                if (windowInsetsCompatY.r()) {
                    return windowInsetsCompatY;
                }
                Rect rect = this.f53774a;
                rect.left = windowInsetsCompatY.k();
                rect.top = windowInsetsCompatY.m();
                rect.right = windowInsetsCompatY.l();
                rect.bottom = windowInsetsCompatY.j();
                int childCount = ViewPager.this.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    WindowInsetsCompat windowInsetsCompatG = ViewCompat.g(ViewPager.this.getChildAt(i3), windowInsetsCompatY);
                    rect.left = Math.min(windowInsetsCompatG.k(), rect.left);
                    rect.top = Math.min(windowInsetsCompatG.m(), rect.top);
                    rect.right = Math.min(windowInsetsCompatG.l(), rect.right);
                    rect.bottom = Math.min(windowInsetsCompatG.j(), rect.bottom);
                }
                return windowInsetsCompatY.t(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        float f3;
        int i4;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.mPageMargin / width;
        int i5 = 0;
        ItemInfo itemInfo = this.mItems.get(0);
        float f5 = itemInfo.f53780e;
        int size = this.mItems.size();
        int i6 = itemInfo.f53777b;
        int i7 = this.mItems.get(size - 1).f53777b;
        while (i6 < i7) {
            while (true) {
                i3 = itemInfo.f53777b;
                if (i6 <= i3 || i5 >= size) {
                    break;
                }
                i5++;
                itemInfo = this.mItems.get(i5);
            }
            if (i6 == i3) {
                float f6 = itemInfo.f53780e;
                float f7 = itemInfo.f53779d;
                f3 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i6);
                f3 = (f5 + pageWidth) * width;
                f5 += pageWidth + f4;
            }
            if (this.mPageMargin + f3 > scrollX) {
                i4 = scrollX;
                this.mMarginDrawable.setBounds(Math.round(f3), this.mTopPageBounds, Math.round(this.mPageMargin + f3), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                i4 = scrollX;
            }
            if (f3 > i4 + r2) {
                return;
            }
            i6++;
            scrollX = i4;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            s();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                b(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                r(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i3 = this.mActivePointerId;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f3 = x3 - this.mLastMotionX;
                float fAbs = Math.abs(f3);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y3 - this.mInitialMotionY);
                if (f3 != 0.0f && !l(this.mLastMotionX, f3) && canScroll(this, false, (int) f3, (int) x3, (int) y3)) {
                    this.mLastMotionX = x3;
                    this.mLastMotionY = y3;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                int i4 = this.mTouchSlop;
                if (fAbs > i4 && fAbs * 0.5f > fAbs2) {
                    this.mIsBeingDragged = true;
                    r(true);
                    setScrollState(1);
                    float f4 = this.mInitialMotionX;
                    float f5 = this.mTouchSlop;
                    this.mLastMotionX = f3 > 0.0f ? f4 + f5 : f4 - f5;
                    this.mLastMotionY = y3;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i4) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && o(x3)) {
                    ViewCompat.d0(this);
                }
            }
        } else if (action == 6) {
            m(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i5;
        setMeasuredDimension(View.getDefaultSize(0, i3), View.getDefaultSize(0, i4));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f53781a) {
                int i8 = layoutParams2.f53782b;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                boolean z3 = i10 == 48 || i10 == 80;
                if (i9 != 3 && i9 != 5) {
                    z2 = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z3) {
                    i5 = Integer.MIN_VALUE;
                    i11 = 1073741824;
                } else {
                    i5 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i12 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i12 != -2) {
                    if (i12 == -1) {
                        i12 = paddingLeft;
                    }
                    i11 = 1073741824;
                } else {
                    i12 = paddingLeft;
                }
                int i13 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i13 == -2) {
                    i13 = measuredHeight;
                    i7 = i5;
                } else if (i13 == -1) {
                    i13 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i12, i11), View.MeasureSpec.makeMeasureSpec(i13, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f53781a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.f53783c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f53781a
            if (r10 != 0) goto L2c
            goto L69
        L2c:
            int r9 = r9.f53782b
            r9 = r9 & 7
            if (r9 == r2) goto L50
            r10 = 3
            if (r9 == r10) goto L4a
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5d
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L46:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5d
        L4a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5d
        L50:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L46
        L5d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L68
            r8.offsetLeftAndRight(r3)
        L68:
            r3 = r9
        L69:
            int r7 = r7 + 1
            goto L1b
        L6c:
            r12.d(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.mPageTransformer
            if (r13 == 0) goto La0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7b:
            if (r1 >= r14) goto La0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f53781a
            if (r0 == 0) goto L8c
            goto L9d
        L8c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.mPageTransformer
            r3.transformPage(r15, r0)
        L9d:
            int r1 = r1 + 1
            goto L7b
        La0:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i4;
        int i5;
        int i6;
        ItemInfo itemInfoInfoForChild;
        int childCount = getChildCount();
        if ((i3 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i6 = 1;
        } else {
            i4 = childCount - 1;
            i5 = -1;
            i6 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.f53777b == this.mCurItem && childAt.requestFocus(i3, rect)) {
                return true;
            }
            i4 += i6;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f53790d, savedState.f53791f);
            setCurrentItemInternal(savedState.f53789c, false, true);
        } else {
            this.mRestoredCurItem = savedState.f53789c;
            this.mRestoredAdapterState = savedState.f53790d;
            this.mRestoredClassLoader = savedState.f53791f;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f53789c = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.f53790d = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 != i5) {
            int i7 = this.mPageMargin;
            p(i3, i5, i7, i7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean pageLeft() {
        int i3 = this.mCurItem;
        if (i3 <= 0) {
            return false;
        }
        setCurrentItem(i3 - 1, true);
        return true;
    }

    boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i3 = 0; i3 < this.mItems.size(); i3++) {
                ItemInfo itemInfo = this.mItems.get(i3);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.f53777b, itemInfo.f53776a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            q();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z2 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z2) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mAdapterChangeListeners.get(i4).a(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i3) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i3, boolean z2, boolean z3) {
        setCurrentItemInternal(i3, z2, z3, 0);
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i3) {
        if (i3 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i3 + " too small; defaulting to 1");
            i3 = 1;
        }
        if (i3 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i3;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i3) {
        int i4 = this.mPageMargin;
        this.mPageMargin = i3;
        int width = getWidth();
        p(width, width, i3, i4);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z2, PageTransformer pageTransformer) {
        setPageTransformer(z2, pageTransformer, 2);
    }

    void setScrollState(int i3) {
        if (this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        if (this.mPageTransformer != null) {
            g(i3 != 0);
        }
        f(i3);
    }

    void smoothScrollTo(int i3, int i4) {
        smoothScrollTo(i3, i4, 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f53781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f53782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f53783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f53784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f53785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f53786f;

        public LayoutParams() {
            super(-1, -1);
            this.f53783c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f53783c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f53782b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[PHI: r7 r10 r15
      0x00cc: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00f0, B:61:0x00da, B:53:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void populate(int r18) {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    void setCurrentItemInternal(int i3, boolean z2, boolean z3, int i4) {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z3 && this.mCurItem == i3 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 >= this.mAdapter.getCount()) {
            i3 = this.mAdapter.getCount() - 1;
        }
        int i5 = this.mOffscreenPageLimit;
        int i6 = this.mCurItem;
        if (i3 > i6 + i5 || i3 < i6 - i5) {
            for (int i7 = 0; i7 < this.mItems.size(); i7++) {
                this.mItems.get(i7).f53778c = true;
            }
        }
        boolean z4 = this.mCurItem != i3;
        if (!this.mFirstLayout) {
            populate(i3);
            t(i3, z2, i4, z4);
        } else {
            this.mCurItem = i3;
            if (z4) {
                e(i3);
            }
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z2, PageTransformer pageTransformer, int i3) {
        boolean z3 = pageTransformer != null;
        boolean z4 = z3 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z3);
        if (z3) {
            this.mDrawingOrder = z2 ? 2 : 1;
            this.mPageTransformerLayerType = i3;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z4) {
            populate();
        }
    }

    void smoothScrollTo(int i3, int i4, int i5) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i6 = scrollX;
        int scrollY = getScrollY();
        int i7 = i3 - i6;
        int i8 = i4 - scrollY;
        if (i7 == 0 && i8 == 0) {
            b(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float f3 = clientWidth;
        float f4 = i9;
        float fDistanceInfluenceForSnapDuration = f4 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i7) * 1.0f) / f3)) * f4);
        int iAbs = Math.abs(i5);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i7) / ((f3 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f), MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i6, scrollY, i7, i8, iMin);
        ViewCompat.d0(this);
    }

    public void setCurrentItem(int i3, boolean z2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i3, z2, false);
    }

    public void setPageMarginDrawable(int i3) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i3));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f3, int i4) {
        }
    }
}
