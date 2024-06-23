import logo from "./logo.svg";
import "./App.css";
import { useMediaQuery } from "react-responsive";
import { colors } from "./assets/colors";
import FooterNavBtn from "./components/FooterNavBtn";

const Layout = (props) => {
  const { className, children } = props;

  // 반응형 화면
  const isDesktopOrLaptop = useMediaQuery({ minWidth: 992 });
  const isTablet = useMediaQuery({ minWidth: 768, maxWidth: 991 });
  const isMobile = useMediaQuery({ maxWidth: 767 });
  const isNotMobile = useMediaQuery({ minWidth: 768 });

  // 새 탭 열기
  const handleOpenNewTab = (url) => {
    window.open(url, "_blank", "noopener, noreferrer");
  };

  return (
    <div className="App">
      <div style={{ minHeight: 500 }}>{children}</div>
      <div>
        <div
          style={{
            paddingTop: isMobile ? 30 : 60,
            paddingBottom: isMobile ? 30 : 60,
            paddingLeft: isMobile ? 30 : 120,
            paddingRight: isMobile ? 30 : 120,
            backgroundColor: colors.footer_bg,
            color: colors.footer_text2,
            marginTop: 100,
          }}
        >
          <div>
            <p style={{ fontSize: isMobile ? 14 : 15 }}>
              <FooterNavBtn
                text={"Spring Boot"}
                onClick={() =>
                  handleOpenNewTab("https://spring.io/")
                }
              />
              <br />
              해당 페이지는 Spring Boot Project Test를 위한 페이지입니다. 
              <br />
              H2 Database와 Spring Server의 실행을 확인 후 진행해주세요.
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Layout;
