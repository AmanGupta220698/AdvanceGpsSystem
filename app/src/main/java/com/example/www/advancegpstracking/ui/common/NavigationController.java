/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.www.advancegpstracking.ui.common;

import android.support.v4.app.FragmentManager;

import com.example.www.advancegpstracking.MainActivity;
import com.example.www.advancegpstracking.R;
import com.example.www.advancegpstracking.ui.HomeModule.HomeFragment;
import com.example.www.advancegpstracking.ui.NotificationModule.NotificationFragment;
import com.example.www.advancegpstracking.ui.TrackingModule.TrackingFragment;

import javax.inject.Inject;



/**
 *
 *
 * A utility class that handles navigation in {@link com.example.www.advancegpstracking.MainActivity}.
 *
 *
 */
public class NavigationController {
    private final int containerId;
    private final FragmentManager fragmentManager;
    @Inject
    public NavigationController(MainActivity mainActivity) {
        System.out.println("NavigationController in ui/common NavigationController anurag");
        this.containerId = R.id.container;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }


    /*public void navigateToSearch() {

        System.out.println("navigateToUser in ui/common NavigationController anurag");

        System.out.println("navigateToSearch in ui/common NavigationController anurag");
        DashboardFragment dashboardFragment = new DashboardFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, dashboardFragment)
                .commitAllowingStateLoss();
    }*/
    public void navigateToUser() {

        System.out.println("navigateToUser in ui/common NavigationController anurag");


        HomeFragment dashboardFragment = new HomeFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, dashboardFragment)
                .commitAllowingStateLoss();
    }


    public void navigateToBooking() {

        System.out.println("navigateToUser in ui/common NavigationController anurag");


        TrackingFragment bookingFragment = new TrackingFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, bookingFragment)
                .commitAllowingStateLoss();
    }

    public void navigateToChatSupport() {

        System.out.println("navigateToChatSupport in ui/common NavigationController anurag");


        NotificationFragment chatSupportFragment = new NotificationFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, chatSupportFragment)
                .commitAllowingStateLoss();
    }

/*
    public void navigateToRepo(String owner, String name) {

        System.out.println("navigateToRepo in ui/common NavigationController anurag");
        ChatSupportFragment fragment = ChatSupportFragment.create(owner, name);
        String tag = "repo" + "/" + owner + "/" + name;
        fragmentManager.beginTransaction()
                .replace(containerId, fragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    public void navigateToUser(String login) {

        System.out.println("navigateToUser in ui/common NavigationController anurag");
        String tag = "user" + "/" + login;
        BookingFragment userFragment = BookingFragment.create(login);
        fragmentManager.beginTransaction()
                .replace(containerId, userFragment, tag)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }*/
}
