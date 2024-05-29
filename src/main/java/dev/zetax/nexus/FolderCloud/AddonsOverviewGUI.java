package dev.zetax.nexus.FolderCloud;

import dev.zetax.nexus.Folders.Folder;
import me.TechsCode.UltraCustomizer.ColorPalette;
import me.TechsCode.UltraCustomizer.UltraCustomizer;
import me.TechsCode.UltraCustomizer.base.gui.Button;
import me.TechsCode.UltraCustomizer.base.gui.Model;
import me.TechsCode.UltraCustomizer.base.gui.pageableview.BasicSearch;
import me.TechsCode.UltraCustomizer.base.gui.pageableview.PageableGUI;
import me.TechsCode.UltraCustomizer.base.gui.pageableview.SearchFeature;
import me.TechsCode.UltraCustomizer.base.item.XMaterial;
import me.TechsCode.UltraCustomizer.base.legacy.Common;
import me.TechsCode.UltraCustomizer.base.visual.Animation;
import me.TechsCode.UltraCustomizer.base.visual.Colors;
import me.TechsCode.UltraCustomizer.base.addons.gui.AddonsMarketplaceListView;
import me.TechsCode.UltraCustomizer.base.addons.gui.InstalledAddonsView;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class AddonsOverviewGUI extends PageableGUI<Folder> {

    private static final Map<String, Folder> folders = new HashMap<>();
    private final UltraCustomizer uc;
    private final Player p;

    public AddonsOverviewGUI(Player p, UltraCustomizer customizer) {
        super(p, customizer);
        this.uc = customizer;
        this.p = p;
    }

    @Override
    public String getTitle() {
        return "Overview > Addons";
    }

    @Override
    public abstract void onBack();

    @Override
    public Folder[] getObjects() {
        // Example folders
        folders.put("Folder 1", new Folder("Folder 1", "This is an example folder.", null));
        folders.put("Folder 2", new Folder("Folder 2", "This is another example folder.", null));
        folders.put("Folder 3", new Folder("Folder 3", "This is yet another example folder.", null));

        return folders.values().toArray(new Folder[0]);
    }

    @Override
    public SearchFeature<Folder> getSearch() {
        return new BasicSearch<Folder>() {
            @Override
            public String[] getSearchableText(Folder folder) {
                return new String[]{folder.getName(), folder.getDescription()};
            }
        };
    }

    @Override
    public void construct(Model gui) {
        gui.setSlots(36);
        gui.button(12, this::MarketplaceButton);
        gui.button(16, this::InstalledAddonsButton);
        gui.button(14, this::openFoldersGUI);
        gui.button(32, (var1x) -> {
            Common.BackButton(var1x, (var1y) -> this.onBack());
        });
        gui.setTitle(this.getTitle());
    }

    private void MarketplaceButton(Button var1) {
        boolean var2 = uc.getAddonManager().isCloudOnline();
        var1.material(XMaterial.EMERALD).name(Animation.wave("Marketplace", var2 ? ColorPalette.MAIN : Colors.Red, Colors.WHITE)).lore(var2 ? "§7Click to browse our §eMarketplace" : "§6Our Marketplace is currently §cunavailable", "", "§7Our Marketplace provides you", "§7with various addons that are", "§7downloadable with just one click!");
        var1.action((var2x) -> {
            if (var2) {
                new AddonsMarketplaceListView(this.p, uc) {
                    public void onBack() {
                        AddonsOverviewGUI.this.reopen();
                    }
                };
            }
        });
    }

    private void InstalledAddonsButton(Button var1) {
        var1.material(XMaterial.HOPPER_MINECART).name(Animation.wave("Installed", ColorPalette.MAIN, Colors.WHITE)).lore("§7Click to view §eInstalled Addons", "", "§7Amount: §e" + uc.getAddonManager().getInstalledAddons().size(), "", "§7View, edit, and remove all installed addons.", "§7Don't want an addon anymore? Then delete it!");
        var1.action((var1x) -> {
            new InstalledAddonsView(this.p, uc) {
                public void onBack() {
                    AddonsOverviewGUI.this.reopen();
                }
            };
        });
    }

    public void openFoldersGUI(Button button) {
        button.material(XMaterial.ENDER_CHEST).name(Animation.wave("Folder Manager", ColorPalette.MAIN, Colors.WHITE)).lore("§7" + "Click to download §efolders §7made by the community", "", "§7Folders are a great way to organize your scripts", "§7and keep your server clean and tidy!");
        button.action((action) -> {

                    //TODO: Open Folders GUI

                }

        );
    }
}