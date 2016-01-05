package com.vaadin.tests.components.tree;

import java.util.Date;

import com.vaadin.server.ExternalResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.tests.util.LoremIpsum;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;

public class TreeWithIcons extends TestBase {

    @Override
    protected void setup() {
        ExternalResource notCachedFolderIconHuge = new ExternalResource(
                "vaadin://themes/runo/icons/64/folder.png?" + new Date().getTime());
        ExternalResource notCachedFolderIconLarge = new ExternalResource(
                "vaadin://themes/runo/icons/32/folder.png?" + new Date().getTime());
        ExternalResource notCachedFolderIconLargeOther = new ExternalResource(
                "vaadin://themes/runo/icons/32/ok.png?" + new Date().getTime());
        Tree t = new Tree();

        t.addItem("Root 1");
        t.addItem("Root 11");
        t.addItem("Root 111");
        t.addItem("Root 1111");
        t.addItem("Sub 1");
        t.setItemIcon("Sub 1", notCachedFolderIconLargeOther);
        t.setParent("Sub 1", "Root 1");
        String longItemId = LoremIpsum.get(50);
        t.addItem(longItemId);
        t.setItemIcon(longItemId, notCachedFolderIconHuge);
        t.setParent(longItemId, "Root 11");
        t.addItem("abcdefghijklmn");

        String first = "abcdefghijklmnop";
        String second = "abcdefghijklmnopqrst";
        t.addItem(first);
        t.addItem(second);
        t.setParent(second, first);
        t.setItemIcon(first, notCachedFolderIconLarge);

        HorizontalLayout hlay = new HorizontalLayout();
        hlay.addComponent(t);
        hlay.setWidth(-1, Unit.PIXELS);

        Panel p = new Panel();
        p.setSizeUndefined();
        p.setContent(hlay);

        add(p);
    }

    @Override
    protected String getTestDescription() {
        return "A tree with icons should resize itself correctly so the nodes are not cut either horizontally or vertically.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3529;
    }

}