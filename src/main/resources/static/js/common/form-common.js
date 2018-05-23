/*点击搜索调用函数刷新表格begin*/
function searchReloadGrid($grid, form_id){
    var grid_param = $grid.jqGrid("getGridParam");
    if (!grid_param) {
        return;
    }
    grid_param.page = 1;
    var post_data = grid_param.postData;
    $.each(post_data, function (key, value) {
        if (key && key.startsWith("param")) {
            delete post_data[key];
        }
    });
    $grid.trigger("reloadGrid");
};
var aui = aui || {};
(function (aui) {
    function grid() {
        aui.grid = aui.grid || {};
        aui.grid.data = aui.grid.data || {};
        aui.grid.param = aui.grid.param || {};

        function init() {
            var default_settings = {
                datatype: 'json',// 从服务器端返回的数据类型，默认xml。可选类型：xml，local，json，jsonnp，script，xmlstring，jsonstring，clientside
                mtype: 'post',
                rowNum: 10,// 每页记录数
                rowList: [10, 20, 50, 100],// 每页记录数可选列表
                viewrecords: true,
                altRows: true,// 斑马线
                autowidth: true,
                height: 'auto',
                // ExpandColClick:true,//当为true时，点击展开行的文本时，treeGrid就能展开或者收缩，不仅仅是点击图片
                // ExpandColumn:null,//指定那列来展开tree
                // grid，默认为第一列，只有在treeGrid为true时起作用
                // gridview:false,//构造一行数据后添加到grid中，如果设为true则是将整个表格的数据都构造完成后再添加到grid中，但treeGrid,
                // subGrid, or afterInsertRow 不能用
                jsonReader: {
                    root: "data.rows",
                    // page: "data.page",
                    total: "data.page",
                    records: "data.total",
                },
                // loadtext:'',//当请求或者排序时所显示的文字内容
                multiselect: true, // 多选框
                pagerpos: "right",// 指定分页栏的位置:center
                // pgtext:'',//当前页信息
                recordpos: "left",// 显示记录数信息位置:'1 - 10 共 37 条'
                // recordtext:'',//1 - 10 共 37 条
                rownumbers: true, // 设置列表显示序号,需要注意在colModel中不能使用rn作为index
                // shrinkToFit : true,//
                // 此属性用来说明当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
                // viewsortcols:[],//定义排序列的外观跟行为。数据格式：[false,'vertical',true].第一个参数是说，是否都要显示排序列的图标，false就是只显示
                // 当前排序列的图标；第二个参数是指图标如何显示，vertical：排序图标垂直放置，horizontal：排序图标水平放置；第三个参数指单击功
                // 能，true：单击列可排序，false：单击图标排序。说明：如果第三个参数为false则第一个参数必须为ture否则不能排序

                beforeRequest: function () {// 发送请求之前补上分页和排序参数以对应后台统一的分页和排序参数
                    var postData = $(this).jqGrid("getGridParam").postData;
                    postData.pageSize = postData.rows;
                    if (postData.sidx != "") {
                        postData.sortname = postData.sidx;
                        postData.sortorder = postData.sord;
                    }
                },
                loadComplete: function (resultMessage) {
                    if (resultMessage.success && (!resultMessage.data.rows || resultMessage.data.rows.length < 1)) {
                        $(this).closest('.ui-jqgrid-view').siblings('.ui-jqgrid-pager').hide();
                        if ($(this).parents('.ui-jqgrid-view').find("div.no-list-pic").length < 1) {
                            $(this).parents('.ui-jqgrid-view').append('<div class="no-list-pic"><div class="pic"></div><p>暂无数据显示</p></div>');
                            $(this).parents('.ui-jqgrid-view').siblings('.ui-jqgrid-pager').find('.ui-paging-info').html(" ");
                        }
                    } else {
                        $(this).closest('.ui-jqgrid-view').siblings('.ui-jqgrid-pager').show();
                        $(this).parents('.ui-jqgrid-view').find("div.no-list-pic").remove();
                    }
                    if (!resultMessage.success) {
                        aui.dialog.error(resultMessage.message);
                    } else {
                        aui.grid.data[this.id] = resultMessage.data.rows;
                    }
                    var $grid = $(this),
                        $tableToolbar = $grid.closest('.ui-jqgrid').siblings('[id$="_edit_tool"]').children('.table-btn-toll');
                    if ($tableToolbar.length && $tableToolbar.find('.grid-col-display').length === 0 && $grid.getGridParam('colModel').length > 1) {
                        var $gridId = $grid.attr('id');
                        $tableToolbar.append(
                            '<div id="' + $gridId + '_display_container" class="pull-right grid-col-display">' +
                            '<a href="javascript:;" class="btn btn-col-display">显示/隐藏列 <span class="caret"></span>' +
                            '</a>' +
                            '<ul class="list-unstyled list-col-display"></ul>' +
                            '</div>');
                        var selectOptions = [];
                        $.each($grid.getGridParam('colModel'), function (key, val) {
                            if (this.name != "rn" && this.name != "cb" && (this.data_display || this.data_display == undefined)) {
                                $('#' + $gridId + '_display_container .list-col-display').append(
                                    '<li>' +
                                    '<div class="checkbox">' +
                                    '<label>' +
                                    '<input type="checkbox" name="' + this.name + '" ' + (!this.hidden ? 'checked=checked' : '') + '">' +
                                    this.label +
                                    '</label>' +
                                    '</div>' +
                                    '</li>');
                            }
                        });
                        $('#' + $gridId + '_display_container .btn-col-display').on('click', function (even) {
                            var $target = $(even.target);
                            var $this = $(this);
                            var $tropdownBox = $this.siblings('.list-col-display');
                            //if($target.hasClass('btn-col-display')){
                            $tropdownBox.toggle(0, function () {
                                $(document).on('click', function (e) {
                                    if ($(e.target).closest('.grid-col-display').length == 0) {
                                        $tropdownBox.hide();
                                    }
                                })
                            }).toggleClass('open');
                            //}
                        });
                        $('#' + $gridId + '_display_container .list-col-display li input:checkbox').change(function () {
                            if (this.checked) {
                                $grid.showCol($(this).attr('name'));
                            } else {
                                $grid.hideCol($(this).attr('name'));
                            }
                        })
                    }
                },
                gridComplete: function () {
                }
            };

            aui.grid.init = function (table_id, settings) {
                var options = $.extend({}, default_settings, settings);
                var pager_id = table_id + '_pager';
                options.pager = '#' + pager_id;// 分页div的ID

                $grid = $('#' + table_id);
                $grid.after('<div id="' + pager_id + '"></div>');
                $grid.jqGrid(options);
                $('#pg_' + table_id + '_pager').on('keyup', '#input_' + table_id + '_pager .ui-pg-input', function () {
                    var $this = $(this);
                    var reg = /^\+?[1-9][0-9]*$/;
                    var val = $.trim($this.val());
                    var maxPage = $this.siblings('[id^="sp_"]').html();
                    if (val != '' && !reg.test(val)) {
                        layer.closeAll('tips');
                        layer.tips('请输入正整数然后敲击回车键跳转到该页数.', $(this), {tips: 1, time: 1500});
                        $this.val('');
                    } else if (parseInt(val) > parseInt(maxPage)) {
                        layer.closeAll('tips');
                        layer.tips('列表总页数为' + maxPage + '页,无法跳转到第' + val + '页.', $(this), {tips: 1, time: 1500});
                        $this.val('');
                    }
                });
                // 增加数据表格随窗口自适应
                $(window).resize(function () {
                    $grid.setGridWidth($('#gbox_' + table_id).parent().width());
                });
                /*var Tbody=$grid.find('tbody').children('tr');
                 if (Tbody=='0') {
                 if (!$grid.parents('.ui-jqgrid-view').find(".no-list-pic")[0]){$grid.parents('.ui-jqgrid-view').append('<div class="no-list-pic"><div class="pic"></div><p>暂无数据显示</p></div>')};
                 };*/
                return $grid;

            }
        }

        init();

        aui.grid.param.reset = function ($grid) {
            var grid_param = $grid.jqGrid("getGridParam");
            if (!grid_param) {
                return;
            }
            grid_param.page = 1;
            var post_data = grid_param.postData;
            $.each(post_data, function (key, value) {
                if (key && key.startsWith("param")) {
                    delete post_data[key];
                }
            });
        };

        aui.grid.param.append = function ($grid, params) {
            var post_data = null;
            var gridParam = $grid.jqGrid("getGridParam");
            if (gridParam) {
                post_data = gridParam.postData;
            }
            $.each(params, function (key, value) {
                post_data[key] = value;
            });
        };

        aui.grid.reload = function ($grid) {
            $grid.trigger("reloadGrid");
        };

        aui.grid.selected = function ($grid) {
            return $grid.jqGrid('getGridParam', 'selarrrow');
        };

        aui.grid.rows = function ($grid) {
            return bui.grid.data[$grid[0].id];
        };
    }

    grid();
})(aui);