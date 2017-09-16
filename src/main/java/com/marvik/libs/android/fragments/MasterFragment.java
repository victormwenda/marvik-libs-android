package com.marvik.libs.android.fragments;

import android.app.Fragment;
import android.content.Intent;

import com.marvik.libs.android.activities.MasterActivity;

/**
 * Project - marvik-libs-android
 * Package - com.marvik.libs.android.fragments
 * <p>
 * Victor Mwenda
 * +254(0)718034449
 * vmwenda.vm@gmail.com
 * <p>
 * Android App Development Laptop
 * Created by victor on 10/20/2016 at 3:46 PM.
 */

public abstract class MasterFragment extends Fragment {
    /**
     * Get the title of the fragment
     *
     * @return
     */
    public abstract String getFragmentTitle();

    /**
     * Get the subtitle of the fragment
     *
     * @return
     */
    public abstract String getFragmentSubTitle();

    /**
     * Set the title of the fragment
     *
     * @param fragmentTitle
     */
    public void setFragmentTitle(String fragmentTitle) {
        ((MasterActivity) getActivity()).setActivityTitle(fragmentTitle);
    }

    /**
     * Set the subtitle of the fragment
     *
     * @param fragmentSubTitle
     */
    public void setFragmentSubTitle(String fragmentSubTitle) {
        ((MasterActivity) getActivity()).setActivitySubtitle(fragmentSubTitle);
    }


    /**
     * Show alert dialog
     *
     * @param title
     * @param message
     * @param positiveButtonLabel
     * @param positiveIntent
     * @param negativeButtonLabel
     * @param negativeIntent
     */
    protected void showAlertDialog(String title, String message, String positiveButtonLabel,
                                   Intent positiveIntent, String negativeButtonLabel, Intent negativeIntent) {
        ((MasterActivity) getActivity()).showAlertDialog(getActivity(), title, message, positiveButtonLabel,
                positiveIntent, negativeButtonLabel, negativeIntent);
    }

    /**
     * Show a progress dialog
     *
     * @param title
     * @param message
     * @param cancellable
     * @param cancellableOnTouchOutside
     */
    public void showProgressDialog(String title, String message, boolean cancellable,
                                   boolean cancellableOnTouchOutside) {
        ((MasterActivity) getActivity()).showProgressDialog(title, message, cancellable, cancellableOnTouchOutside);
    }

    protected void closeProgressDialog() {
        ((MasterActivity) getActivity()).tryCloseProgressDialog();
    }

}