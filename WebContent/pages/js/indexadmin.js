var previewwidth = $( ".picture" ).width();

$(".picture").height( previewwidth );
$(".item").height( previewwidth + 100 );

$( window ).resize(function() {
    $(".picture").height( previewwidth );
    $(".item").height( previewwidth + 100 );
});

$(".search")
  .keyup(function() {
    var search = $(this).val();
    console.log(search);
    $(".grid .item").removeClass("active");
    $('.grid .item:contains("' + search + '")').addClass("active");
  });

//ZurÃ¼cksetzen der aktiven Elemente sowie Aufruf der Unterseite, die mit Hilfe des Attributs "data-target" im ".pointer" gekennzeichnet ist
		$(".pointer").click(function(){
			var page = $(this).attr("data-target");
			$(".page").removeClass("active");
			$(".pointer").removeClass("active");
			$("#menutoggle").removeClass("active");
			$("#menu").removeClass("active");
			$(page).addClass("active");
			$(this).addClass("active");
			var hash = $(this).attr("data-target");
			document.location.hash = hash;
		});

//ZurÃ¼cksetzen der aktiven Elemente sowie Aufruf der im Hash verlinkten Unterseite Ã¼ber Aufruf der Seite
		$(document).ready(function() {
      			var income = window.location.hash;
				if (income!=0) {
					$(".pointer").removeClass("active");
					$(".page").removeClass("active");
					$(income).toggleClass("active");
					$("[data-target='"+income+"']").toggleClass("active");
				};
		});
		
//ZurÃ¼cksetzen der aktiven Elemente sowie Aufruf der im Hash verlinkten Unterseite Ã¼ber Back/Forward
		$(window).on('hashchange', function() {
		  var income = window.location.hash;
				if (income!=0) {
					$(".pointer").removeClass("active");
					$(".page").removeClass("active");
					$(income).toggleClass("active");
					$("[data-target='"+income+"']").toggleClass("active");
				};
		});

//Knopf zum Ã¶ffnen des MenÃ¼s
		$(".toggle").click(function(){
			var page = $(this).attr("data-target");
			$(page).toggleClass("active");
			$(this).toggleClass("active");
		});

		$(".page").click(function(){
			$("#player").removeClass("active");
			$("#menu").removeClass("active");
			$(".toggle").removeClass("active");
		});

//Kopieren von HTML Content via data-target
		$(window).load(function() {
			$(".copy").each(function() {
      			var target = $(this).attr("data-target")
      			var html = $(target).html();
      			$(this).html(html);
			});
		});