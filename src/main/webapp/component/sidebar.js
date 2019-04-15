document.writeln("<div class=\'sidebar\' id=\'sidebar\'>");
document.writeln("    <script type=\'text/javascript\'>");
document.writeln("        try{ace.settings.check(\'sidebar\' , \'fixed\')}catch(e){}");
document.writeln("    </script>");
document.writeln("");
document.writeln("    <div class=\'sidebar-shortcuts\' id=\'sidebar-shortcuts\'>");
document.writeln("        <div class=\'sidebar-shortcuts-large\' id=\'sidebar-shortcuts-large\'>");
document.writeln("            <button class=\'btn btn-success\'>");
document.writeln("                <i class=\'icon-signal\'></i>");
document.writeln("            </button>");
document.writeln("");
document.writeln("            <button class=\'btn btn-info\'>");
document.writeln("                <i class=\'icon-pencil\'></i>");
document.writeln("            </button>");
document.writeln("");
document.writeln("            <button class=\'btn btn-warning\'>");
document.writeln("                <i class=\'icon-group\'></i>");
document.writeln("            </button>");
document.writeln("");
document.writeln("            <button class=\'btn btn-danger\'>");
document.writeln("                <i class=\'icon-cogs\'></i>");
document.writeln("            </button>");
document.writeln("        </div>");
document.writeln("");
document.writeln("        <div class=\'sidebar-shortcuts-mini\' id=\'sidebar-shortcuts-mini\'>");
document.writeln("            <span class=\'btn btn-success\'></span>");
document.writeln("");
document.writeln("            <span class=\'btn btn-info\'></span>");
document.writeln("");
document.writeln("            <span class=\'btn btn-warning\'></span>");
document.writeln("");
document.writeln("            <span class=\'btn btn-danger\'></span>");
document.writeln("        </div>");
document.writeln("    </div><!-- #sidebar-shortcuts -->");
document.writeln("");
document.writeln("    <ul class=\'nav nav-list\'>");
document.writeln("        <li >");
document.writeln("            <a class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-desktop\'></i>");
document.writeln("                <span class=\'menu-text\' > 个人信息管理</span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a id=\'selfEdit\' href=\'/admin/edit?id=\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        个人信息修改");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("");
document.writeln("        </li>");
document.writeln("");
document.writeln("        <li class=\'studentHidden\'>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-user\'></i>");
document.writeln("                <span class=\'menu-text\'>人员管理</span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li class=\'teacherHidden\'>");
document.writeln("                    <a href=\'/teacher/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        教师管理");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("");
document.writeln("                <li>");
document.writeln("                    <a href=\'/student/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        学生管理");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'teacherHidden\'>");
document.writeln("                    <a href=\'/cooperator/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        合作者管理");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li class=\'teacherHidden\'>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-building\'></i>");
document.writeln("                <span class=\'menu-text\'> 新闻管理 </span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/news/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        新闻列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li class=\'teacherHidden\'>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-building\'></i>");
document.writeln("                <span class=\'menu-text\'> 合作企业管理 </span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/company/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        企业列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-list\'></i>");
document.writeln("                <span class=\'menu-text\'> 论文管理</span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/paper/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        论文列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-list\'></i>");
document.writeln("                <span class=\'menu-text\'> 项目管理</span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/project/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        项目列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li class=\'studentHidden\'>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-list\'></i>");
document.writeln("                <span class=\'menu-text\'> 课程管理 </span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/course/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        课程列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("        <li class=\'studentHidden\'>");
document.writeln("            <a href=\'#\' class=\'dropdown-toggle\'>");
document.writeln("                <i class=\'icon-list\'></i>");
document.writeln("                <span class=\'menu-text\'> 著作管理 </span>");
document.writeln("");
document.writeln("                <b class=\'arrow icon-angle-down\'></b>");
document.writeln("            </a>");
document.writeln("            <ul class=\'submenu\'>");
document.writeln("                <li>");
document.writeln("                    <a href=\'/book/index\'>");
document.writeln("                        <i class=\'icon-double-angle-right\'></i>");
document.writeln("                        著作列表");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </li>");
document.writeln("");
document.writeln("");
document.writeln("");
document.writeln("    </ul>");
document.writeln("");
document.writeln("    <div class=\'sidebar-collapse\' id=\'sidebar-collapse\'>");
document.writeln("        <i class=\'icon-double-angle-left\' data-icon1=\'icon-double-angle-left\' data-icon2=\'icon-double-angle-right\'></i>");
document.writeln("    </div>");
document.writeln("");
document.writeln("    <script type=\'text/javascript\'>");
document.writeln("        try{ace.settings.check(\'sidebar\' , \'collapsed\')}catch(e){}");
document.writeln("    </script>");
document.writeln("</div>");
document.writeln("");